package com.gfang.sevennineone.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.*;
import com.gfang.sevennineone.service.*;
import com.gfang.sevennineone.util.SnoUtil;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * 联盟活动
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoAlliance")
public class SnoAllianceController {
	@Autowired
	private SnoMerchantService snoMerchantService;
	@Autowired
	private SnoAllianceActivityService snoAllianceActivityService;
	@Autowired
	private SnoAllianceMerchantService snoAllianceMerchantService;
	@Autowired
	private SnoMerchantSubjectService snoMerchantSubjectService;
	@Autowired
	private SnoReplyService snoReplyService;
	@Autowired
	private SnoReplyImageService snoReplyImageService;
	@Autowired
	private SnoUserService snoUserService;

	// 查找商家参与的活动
	@GetMapping("/listByMerchantId")
	public ApiResultVO listByMerchantId(@RequestParam(value="merchantId",required = false) Integer merchantId){
		ApiResultVO apiResultVO = new ApiResultVO();
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("merchantId",merchantId);
		paramMap.put("status",1);
		List<SnoAllianceMerchantPO> merchantList = snoAllianceMerchantService.listByParams(paramMap);
		if(!merchantList.isEmpty()){
			List<Map<String,Object>> activityList = snoAllianceActivityService.listByIds(
					Lists.transform(merchantList,
							input -> input.getActivityId()
					).toArray(new Integer[merchantList.size()])
			);
			apiResultVO.setData(activityList);
		}else{
			apiResultVO.setData(new Integer[]{});
		}
		return apiResultVO;
	}

	// 通过条件查找活动
	@GetMapping("/listActivity")
	public ApiResultVO listActivity(@RequestParam(value = "name", required = false) String name,
									@RequestParam(value = "province", required = false) String province,
									@RequestParam(value = "city", required = false) String city,
									@RequestParam(value = "area", required = false) String area,
									@RequestParam(value = "placeLevel", required = false) Integer placeLevel,
									@RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
									@RequestParam(value = "rowCount", required = false, defaultValue = "10") Integer rowCount
	) {
		ApiResultVO apiResultVO = new ApiResultVO();
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("name",name);
		paramMap.put("province",province);
		paramMap.put("city",city);
		paramMap.put("area",area);
		paramMap.put("placeLevel",placeLevel);
		paramMap.put("current",current);
		paramMap.put("start",(current-1)*rowCount);
		paramMap.put("rowCount",rowCount);
		Integer total = snoAllianceActivityService.getListActivityCount(paramMap);
		List<Map<String,Object>> list = snoAllianceActivityService.listActivity(paramMap);

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("total",total);
		resultMap.put("list",list);
		apiResultVO.setData(resultMap);
		return apiResultVO;
	}

	// 查看活动详情
	@GetMapping("/getActivityById")
	public ApiResultVO getActivityById(@RequestParam("id") Integer id){
		ApiResultVO apiResultVO = new ApiResultVO();
		Gson gson = new GsonBuilder().serializeNulls().create();
		// 活动详情
		Map<String,Object> activity = snoAllianceActivityService.getMapById(id);

		// 活动商家详情
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("activityId",id);
		paramMap.put("status",1);
		List<SnoAllianceMerchantPO> aMerchantList = snoAllianceMerchantService.listByParams(paramMap);
		if(aMerchantList.size()>0){
			List<Map<String,Object>> merchantList =  snoMerchantService.listByIds(
					Lists.transform(aMerchantList,
							input -> input.getMerchantId()
					).toArray(new Integer[aMerchantList.size()])
			);
			for (Map<String, Object> merchant : merchantList) {
				for (SnoAllianceMerchantPO allianceMerchantPO : aMerchantList) {
					if (((Integer) merchant.get("id")).equals(allianceMerchantPO.getMerchantId())) {
						merchant.put("experienceNum", allianceMerchantPO.getExperienceNum());
						break;
					}
				}
			}
			activity.put("merchantList",merchantList);
		}else{
			activity.put("merchantList",new String[]{});
		}

		apiResultVO.setData(activity);
		return apiResultVO;
	}

	// 查看活动下的商家和课程
	@GetMapping("listMerchantByActivityId")
	public ApiResultVO listMerchantByActivityId(@RequestParam("activityId") Integer activityId){
		ApiResultVO apiResultVO = new ApiResultVO();

		// 查找商家
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("activityId",activityId);
		paramMap.put("status",1);
		List<SnoAllianceMerchantPO> aMerchantList = snoAllianceMerchantService.listByParams(paramMap);

		Integer[] merchantIds = Lists.transform(aMerchantList, input ->
				input.getMerchantId()
		).toArray(new Integer[aMerchantList.size()]);

		List<Map<String, Object>> merchantList = snoMerchantService.listByIds(merchantIds);

		for (SnoAllianceMerchantPO allianceMerchant : aMerchantList) {
			for (Map<String, Object> merMap : merchantList) {
				if(allianceMerchant.getMerchantId().equals(merMap.get("id"))){
					merMap.put("allianceMerchant",allianceMerchant);
					break;
				}
			}
		}

		// 查找商家的课程
		List<SnoMerchantSubjectPO> subjectList = snoMerchantSubjectService.listByMerchantIds(merchantIds);

		for (Map<String, Object> merMap : merchantList) {
			merMap.put("subjectList",new ArrayList<SnoMerchantSubjectPO>());
			for (SnoMerchantSubjectPO subjectPO : subjectList) {
				if(subjectPO.getmerchantId().equals(merMap.get("id"))){
					((ArrayList)merMap.get("subjectList")).add(subjectPO);
				}
			}
		}

		apiResultVO.setData(merchantList);

		return apiResultVO;
	}

	// 查找商家排行榜
	@GetMapping("listLeaderBorder")
	public ApiResultVO listLeaderBorder(@RequestParam("aid") Integer aid){
		ApiResultVO apiResultVO = new ApiResultVO();

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("activityId",aid);
		paramMap.put("status",1);
		List<SnoAllianceMerchantPO> snoAllianceMerchantPOS = snoAllianceMerchantService.listByParams(paramMap);
		if(snoAllianceMerchantPOS.size()>0){
			List<Map<String, Object>> merchantMaps = snoMerchantService.listByIds(
					Lists.transform(snoAllianceMerchantPOS,
							input -> input.getMerchantId()
					).toArray(new Integer[snoAllianceMerchantPOS.size()])
			);

			merchantMaps.sort(new Comparator<Map<String, Object>>() {
				@Override
				public int compare(Map<String, Object> o1, Map<String, Object> o2) {
					return (int)o2.get("hotNum") - (int)o1.get("hotNum") ;
				}
			});

			apiResultVO.setData(merchantMaps);
		}else{
			apiResultVO.setData(new String[]{});
		}



		return apiResultVO;
	}

	// 加入活动
	@GetMapping("joinActivity")
	public ApiResultVO joinActivity(@RequestParam("experienceNum") Integer experienceNum,
									@LoginUser SnoUserPO user,
									@RequestParam("aid") Integer aid){
		ApiResultVO apiResultVO = new ApiResultVO();
		SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());
		if (merchant != null) {
			SnoAllianceMerchantPO aMerchant = new SnoAllianceMerchantPO();
			aMerchant.setActivityId(aid);
			aMerchant.setMerchantId(merchant.getId());
			aMerchant.setStatus(
					merchant.getAuditStatus() == 2
							? 1
							: 0);
			aMerchant.setExperienceNum(experienceNum);
			snoAllianceMerchantService.save(aMerchant);
		}else{
			apiResultVO.setCode(-1);
			apiResultVO.setMessage("找不到商家");
		}

		return apiResultVO;
	}

	// 查询商家是否加入活动
	@GetMapping("getExistsByAidAndMid")
	public ApiResultVO getExistsByAidAndMid(@LoginUser SnoUserPO user,
											@RequestParam("aid") Integer aid){
		ApiResultVO apiResultVO = new ApiResultVO();
		SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());
		apiResultVO.setData(false);
		if(merchant!=null){
			Map<String, Object> existsByAidAndMid = snoAllianceMerchantService.getExistsByAidAndMid(aid, merchant.getId());
			apiResultVO.setData(existsByAidAndMid!=null);
		}
		return apiResultVO;
	}

	// 增加活动
	@PostMapping("addActivity")
	public ApiResultVO addActivity(@LoginUser SnoUserPO user,
								   @RequestBody SnoAllianceActivityPO activityPO) throws IOException {
		ApiResultVO apiResultVO = new ApiResultVO();
		activityPO.setUserId(user.getId());
		activityPO.setPlaceLevel(StringUtils.isEmpty(activityPO.getArea())?2:3);
		activityPO.setLogo(SnoUtil.downloadWxImage(activityPO.getLogo()));

		Integer i = snoAllianceActivityService.save(activityPO);
		apiResultVO.setData(i);
		return apiResultVO;
	}


	// 查找活动 审核
	@GetMapping("listActivityForAudit")
	public ApiResultVO listActivityForAudit(@RequestParam("auditStatus") Integer auditStatus,
											@RequestParam(value = "current", defaultValue = "1") Integer current,
											@RequestParam(value = "rowCount", defaultValue = "10") Integer rowCount){
		ApiResultVO apiResultVO = new ApiResultVO();

		HashMap<String, Object> paramMap = new HashMap<>();
		if(auditStatus!=0){
			paramMap.put("auditStatus",auditStatus);
		}
		paramMap.put("start",(current-1)*rowCount);
		paramMap.put("rowCount",rowCount);
		List<Map<String, Object>> activityList = snoAllianceActivityService.listActivity(paramMap);
		Integer total = snoAllianceActivityService.getActivityCountByMap(paramMap);

		if(total>0){
			List<SnoUserPO> userList = snoUserService.listByIds(
					Lists.transform(activityList,
							input -> input.get("userId")
					).toArray(new String[activityList.size()])
			);

			for (Map<String, Object> activity : activityList) {
				for (SnoUserPO userPO : userList) {
					if(activity.get("userId").equals(userPO.getId())){
						activity.put("userinfo",userPO);
						break;
					}
				}
			}
		}

		Map<String, Object> resMap = new HashMap<>();
		resMap.put("list",activityList);
		resMap.put("total",total);

		apiResultVO.setData(resMap);
		return apiResultVO;
	}

	// 审核活动
	@GetMapping("auditActivity")
	public ApiResultVO auditActivity(@RequestParam("activityId") Integer activityId,
									 @RequestParam("auditStatus") Integer auditStatus,
									 @RequestParam(value="auditFailMsg",required = false) String auditFailMsg){
		ApiResultVO apiResultVO = new ApiResultVO();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("activityId",activityId);
		paramMap.put("auditFailMsg",auditFailMsg);
		paramMap.put("fromStatus",1);
		paramMap.put("toStatus",auditStatus);

		Integer i = snoAllianceActivityService.updateForAudit(paramMap);
		apiResultVO.setData(i);

		return apiResultVO;
	}

	// 搜索商家或学生
	@GetMapping("search")
	public ApiResultVO search(@RequestParam("word") String word,
							  @RequestParam("aid") Integer aid){
		ApiResultVO apiResultVO = new ApiResultVO();
		// 商家
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("aid",aid);
		paramMap.put("word",word);

		List<Map<String, Object>> merchantList = snoAllianceMerchantService.listMerchantForSearch(paramMap);

		List<Map<String, Object>> childList = snoReplyService.listReplyForSearch(paramMap);

		if(childList.size()>0){
			// 图片
			List<SnoReplyImagePO> imageList =  snoReplyImageService.listByReplyIds(
					Lists.transform(childList,
							input -> input.get("id")
					).toArray(new Integer[childList.size()])
			);
			for (Map<String, Object> replyMap : childList) {
				List<String> imageListProp = new ArrayList<>();
				for (SnoReplyImagePO image : imageList) {
					if(image.getReplyId().equals(replyMap.get("id"))){
						imageListProp.add(image.getUrl());
					}
					replyMap.put("imageList",imageListProp);
				}
			}
		}

		Map<String, Object> resMap = new HashMap<>();
		resMap.put("childList",childList);
		resMap.put("merchantList",merchantList);

		apiResultVO.setData(resMap);
		return apiResultVO;
	}
}
