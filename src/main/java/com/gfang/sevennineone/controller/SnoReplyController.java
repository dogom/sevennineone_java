package com.gfang.sevennineone.controller;

import java.io.IOException;
import java.util.*;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.*;
import com.gfang.sevennineone.model.vo.SnoReplyVO;
import com.gfang.sevennineone.service.*;
import com.gfang.sevennineone.util.SnoUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报名表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoReply")
public class SnoReplyController {
	@Autowired
	private SnoReplyService snoReplyService;
	@Autowired
	private SnoReplyImageService snoReplyImageService;
	@Autowired
	private SnoUserService snoUserService;
	@Autowired
	private SnoMerchantService snoMerchantService;
	@Autowired
	private SnoMerchantSubjectService snoMerchantSubjectService;
	@Autowired
	private SnoAllianceActivityService snoAllianceActivityService;
	@Autowired
	private SnoAllianceMerchantService snoAllianceMerchantService;

	// 查看用户是否报名某个活动
	@GetMapping("/getMyReplyByMId")
	public ApiResultVO getMyReplyByMId(@LoginUser SnoUserPO user,
									   @RequestParam(value="token",required = false) String token,
									   @RequestParam("aid") Integer aid,
									   @RequestParam("mid") Integer mid
									   ){
		ApiResultVO apiResultVO = new ApiResultVO();
		String openid = user != null
				? user.getOpenid()
				: token != null
				? token : null;
		List<Map<String,Object>> replyList = new ArrayList<>();
		if (user != null) {
			replyList = snoReplyService.getByOpenidAndMerchantId(openid,aid,mid);
		}
		if (replyList.size() > 0) {
			List<SnoReplyImagePO> imageList =  snoReplyImageService.listByReplyIds(
					Lists.transform(replyList,
							input -> input.get("id")
					).toArray(new Integer[replyList.size()])
			);

			for (Map<String, Object> replyMap : replyList) {
				List<String> imageListProp = new ArrayList<>();
				for (SnoReplyImagePO image : imageList) {
					if(image.getReplyId().equals(replyMap.get("id"))){
						imageListProp.add(image.getUrl());
					}
					replyMap.put("imageList",imageListProp);
				}
			}
		}



		apiResultVO.setData(replyList);
		return apiResultVO;
	}

	// 查看活动报名信息 aid活动 mid机构
	@GetMapping("/listReplyByAidAndMid")
	public ApiResultVO listReplyByAidAndMid(@RequestParam("aid") Integer aid,
											@RequestParam("mid") Integer mid,
											@RequestParam(value = "current",defaultValue = "1") Integer current,
											@RequestParam(value = "rowCount",defaultValue = "10") Integer rowCount
	){
		ApiResultVO apiResultVO = new ApiResultVO();
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("aid", aid);
		paramMap.put("mid", mid);
		paramMap.put("start", (current - 1) * rowCount);
		paramMap.put("rowCount", rowCount);
		Long total = snoReplyService.getReplyCountByMap(paramMap);
		List<Map<String,Object>> list = snoReplyService.listReplyByMap(paramMap);

		if (total > 0L) {
			List<String> replyOpenids = new ArrayList<>();
			for (Map<String, Object> map : list) {
				String openid = (String) map.get("openid");
				replyOpenids.add(openid);
			}

			List<SnoUserPO> userList =  snoUserService.listByOpenids(replyOpenids.toArray(new String[replyOpenids.size()]));

			for (Map<String, Object> reply : list) {
				for (SnoUserPO user : userList) {
					if(reply.get("openid").toString().equals(user.getOpenid())){
						reply.put("avatar",user.getAvatar());
						reply.put("nickname",user.getNickname());
						break;
					}
				}
			}
		}
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("list",list);
		resMap.put("total",total);
		apiResultVO.setData(resMap);

		return apiResultVO;
	}

	// 报名接口
	@PostMapping("/reply")
	public ApiResultVO reply(@RequestBody SnoReplyVO snoReplyVO, @LoginUser SnoUserPO user) throws IOException {
		ApiResultVO apiResultVO = new ApiResultVO();
		/** 1、保存基本信息 */
		SnoReplyPO snoReplyPO = new SnoReplyPO();
		BeanUtils.copyProperties(snoReplyVO,snoReplyPO);
		if(snoReplyPO.getChildName()==null
				|| snoReplyPO.getChildAge()==null
				|| snoReplyPO.getChildSex()==null
				|| snoReplyPO.getSchoolInfo()==null
				|| snoReplyPO.getSubjectId()==null
				|| snoReplyVO.getLifePhoto()==null
				){
			apiResultVO.setCode(-1);
			apiResultVO.setMessage("参数错误");
			return apiResultVO;
		}
		snoReplyPO.setOpenid(user.getOpenid());
		snoReplyPO.setPaidFee(0);

		SnoMerchantSubjectPO subject = snoMerchantSubjectService.getById(snoReplyPO.getSubjectId());
		snoReplyPO.setTotalFee(subject.getPrice());

		Long i = snoReplyService.save(snoReplyPO);
		if (i > 0) {
			apiResultVO.setData(i);

			/** 2、保存图片 */
			String lifePhotoUrl = snoReplyVO.getLifePhoto();
			SnoReplyImagePO image = new SnoReplyImagePO();
			image.setUrl(SnoUtil.downloadWxImage(lifePhotoUrl));
			image.setReplyId(i.intValue());
			snoReplyImageService.save(image);
		}

		return apiResultVO;
	}

	// 报名详情
	@GetMapping("/getReplyDetail")
	public ApiResultVO getReplyDetail(@RequestParam("replyId") Integer replyId){
		ApiResultVO apiResultVO = new ApiResultVO();
		// 报名信息
		Map<String,Object> reply = snoReplyService.getMapById(replyId);
		List<SnoReplyImagePO> imageList = snoReplyImageService.listByReplyId((Integer) reply.get("id"));
		reply.put("imageList", imageList);
		// 用户信息
		Map<String,Object> user = snoUserService.getMapByOpenid((String) reply.get("openid"));
		reply.put("userinfo",user);
		// 商户信息
		SnoMerchantPO merchant = snoMerchantService.getById((Integer) reply.get("merchantId"));
		reply.put("categoryName",merchant.getCategoryName());
		reply.put("merchantName",merchant.getName());

		apiResultVO.setData(reply);

		return apiResultVO;
	}

	// 查找用户所有报名信息
	@GetMapping("/listReplyByUser")
	public ApiResultVO listReplyByUser(@LoginUser SnoUserPO user,
									   @RequestParam(value = "current", defaultValue = "1") Integer current,
									   @RequestParam(value = "rowCount", defaultValue = "10") Integer rowCount) {
		ApiResultVO apiResultVO = new ApiResultVO();
		if (user == null) {
			apiResultVO.setCode(-1);
			apiResultVO.setMessage("用户未授权登录");
		} else {
			Integer total = snoReplyService.getUserReplyCount(user.getOpenid());
			List<Map<String, Object>> replyList = snoReplyService.listReplyByUser(user.getOpenid(), (current - 1) * rowCount, rowCount);

			if (total > 0) {
				// 图片
				List<SnoReplyImagePO> imageList =  snoReplyImageService.listByReplyIds(
						Lists.transform(replyList,
								input -> input.get("id")
						).toArray(new Integer[replyList.size()])
				);
				for (Map<String, Object> replyMap : replyList) {
					List<String> imageListProp = new ArrayList<>();
					for (SnoReplyImagePO image : imageList) {
						if(image.getReplyId().equals(replyMap.get("id"))){
							imageListProp.add(image.getUrl());
						}
						replyMap.put("imageList",imageListProp);
					}
				}

				// 商家信息
				List<Map<String, Object>> merchantList = snoMerchantService.listByIds(
						Lists.transform(replyList, input ->
								input.get("merchantId")
						).toArray(new Integer[replyList.size()])
				);
				for(Map<String,Object> replyMap : replyList){
					for (Map<String, Object> merchantMap : merchantList) {
						if(replyMap.get("merchantId").equals(merchantMap.get("id"))){
							replyMap.put("merchantName",merchantMap.get("name"));
							break;
						}
					}
				}

			}

			HashMap<String, Object> resMap = new HashMap<>();
			resMap.put("list",replyList);
			resMap.put("total",total);
			apiResultVO.setData(resMap);
		}

		return apiResultVO;
	}


	// 查找可预约试课的活动列表
	@GetMapping("listAppointmentA")
	public ApiResultVO listAppointmentA(@LoginUser SnoUserPO user){
		ApiResultVO apiResultVO = new ApiResultVO();

		List<Integer> activityIdList = snoReplyService.listAppointmentA(user.getOpenid());

		if(activityIdList.size()>0){
			Integer[] ids = activityIdList.toArray(new Integer[activityIdList.size()]);
			List<Map<String, Object>> activityList = snoAllianceActivityService.listByIds(ids);

			apiResultVO.setData(activityList);
		}else{
			apiResultVO.setData(new Integer[]{});
		}

		return apiResultVO;
	}
}
