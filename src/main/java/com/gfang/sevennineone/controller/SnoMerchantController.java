package com.gfang.sevennineone.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoAllianceMerchantPO;
import com.gfang.sevennineone.model.po.SnoMerchantImgPO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.model.vo.SnoMerchantVO;
import com.gfang.sevennineone.service.*;
import com.gfang.sevennineone.util.SnoUtil;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.gfang.sevennineone.model.po.SnoMerchantPO;

/**
 * 机构表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoMerchant")
public class SnoMerchantController {
	private Logger logger = LoggerFactory.getLogger(SnoMerchantController.class);

	@Autowired
	private SnoMerchantService snoMerchantService;
	@Autowired
	private SnoAllianceMerchantService snoAllianceMerchantService;
	@Autowired
	private SnoMerchantSubjectService snoMerchantSubjectService;
	@Autowired
	private SnoMerchantImgService snoMerchantImgService;
	@Autowired
	private SnoUserService snoUserService;

	@GetMapping("/listMerchant")
	public ApiResultVO listMerchant(@RequestParam(value="categoryId",required = false) Integer categoryId,
									@RequestParam(value="province",required = false) String province,
									@RequestParam(value="city",required = false) String city,
									@RequestParam(value="area",required = false) String area,
									@RequestParam(value="latng",required = false) String latng,
									@RequestParam(value="current") Integer current,
									@RequestParam(value="rowCount") Integer rowCount){
		ApiResultVO apiResultVO = new ApiResultVO();
		HashMap<String, Object> paramMap = new HashMap<>();
		Integer start = (current-1) * rowCount;
		paramMap.put("categoryId",categoryId);
		paramMap.put("province",province);
		paramMap.put("city",city);
		paramMap.put("area",area);
		paramMap.put("start",start);
		paramMap.put("rowCount",rowCount);
		paramMap.put("auditStatus",2);
		HashMap<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> maps = snoMerchantService.listMerchant(paramMap);

		resultMap.put("list",maps);

		// 腾讯地图调用地理位置计算距离
		try{
			if (!StringUtils.isEmpty(latng)) {
				List<String> toLatngArr = new ArrayList<>();
				for (Map<String, Object> map : maps) {
					String bmap_loc = (String) map.get("bmap_loca");
					if (!StringUtils.isEmpty(bmap_loc)) {
						toLatngArr.add((String) map.get("bmap_loca"));
					}
				}
				String positionUrl = "https://apis.map.qq.com/ws/distance/v1/?mode=driving&from="+latng+"&to="+StringUtils.join(toLatngArr,',')+"&key=XOOBZ-3G2WU-ME2VZ-4AG7A-4NDTT-Z4F7O";
				String res = SnoUtil.httpGetMethod(positionUrl);
				resultMap.put("distance",res);
			}
		} catch (IOException e) {
			logger.error("首页获取距离接口错误！ {}", e.getMessage());
		}


		apiResultVO.setData(resultMap);
		return apiResultVO;
	}

	@GetMapping("/seller")
	public ApiResultVO seller(@RequestParam("id") Integer id,@RequestParam(value = "aid",required = false) Integer aid){
		ApiResultVO apiResultVO = new ApiResultVO();
		Map<String,Object> po = snoMerchantService.getMerchantById(id);
		if (aid != null) {
			Map<String,Object> aMerchant = snoAllianceMerchantService.getByAidAndMid(aid,id);
			po.put("experienceNum",aMerchant.get("experienceNum"));
			po.put("replyCount",aMerchant.get("replyCount"));

			SnoUserPO user = snoUserService.getById((String) po.get("user_id"));
			po.put("mobile",user==null?null:user.getMobile());
		}
		List<Map<String, Object>> subjectList = snoMerchantSubjectService.listSubject(id);
		po.put("subjectList",subjectList);
		apiResultVO.setData(po);
		return apiResultVO;
	}

	@PostMapping("/save")
	public ApiResultVO save(@RequestBody SnoMerchantVO vo, @LoginUser SnoUserPO user) throws IOException {

		SnoMerchantPO po = new SnoMerchantPO();
		BeanUtils.copyProperties(vo,po);


		Integer merchantId = null;
		ApiResultVO apiResultVO = new ApiResultVO();
		if (user == null) {
			apiResultVO.setCode(-1);
			apiResultVO.setMessage("用户未登录");
		} else {
			logger.info("商家入驻数据：{}", po);

			SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());
			po.setLogo(SnoUtil.downloadWxImage(po.getLogo()));
			po.setBusinessLicense(SnoUtil.downloadWxImage(po.getBusinessLicense()));
			po.setBanner(SnoUtil.downloadWxImage(po.getBanner()));
			if (merchant == null) {
				po.setUserId(user.getId());
				po.setAuditStatus(0);
				merchantId = snoMerchantService.save(po);
				apiResultVO.setData(merchantId);
			}else{
				merchantId = merchant.getId();
				po.setId(merchant.getId());
				snoMerchantService.update(po);
				apiResultVO.setData(merchant.getId());
			}

			//添加图片
			if(vo.getMerchantImgList()!=null && vo.getMerchantImgList().size()>0){
				List<SnoMerchantImgPO> merchantImgList = new ArrayList<>();
				for (String url : vo.getMerchantImgList()) {
					SnoMerchantImgPO img = new SnoMerchantImgPO(SnoUtil.downloadWxImage(url),merchantId,null);
					merchantImgList.add(img);
				}
				Integer i = snoMerchantImgService.saveBatch(merchantImgList);
			}
		}

		return apiResultVO;
	}

	@GetMapping("downloadWxImage")
	public String downloadWxImage(@RequestParam("image") String image) throws IOException {
		String s = SnoUtil.downloadWxImage(image);
		return s;

	}

	@GetMapping("/getMerchantJoinInfo")
	public ApiResultVO getMerchantJoinInfo(@LoginUser SnoUserPO user) {
		ApiResultVO apiResultVO = new ApiResultVO();
		Map<String, Object> merchantMap = null;
		if (user != null) {
			SnoMerchantPO merchantPO = snoMerchantService.getByUserId(user.getId());
			if(merchantPO!=null){
				merchantMap = SnoUtil.beanToMap(merchantPO);
				List<SnoMerchantImgPO> snoMerchantImgPOS = snoMerchantImgService.listByMerchantId(merchantPO.getId());
				merchantMap.put("imgList",
						Lists.transform(snoMerchantImgPOS,input -> input.getUrl())
						);
			}
		}
		apiResultVO.setData(merchantMap);
		return apiResultVO;
	}

	@GetMapping("updateAddressInfo")
	public ApiResultVO updateAddressInfo(@LoginUser SnoUserPO user,
										 @RequestParam("address") String address,
										 @RequestParam("bmapLoca") String bmapLoca){
		ApiResultVO apiResultVO = new ApiResultVO();
		/** 1、参数验证 */
		SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());
		/** 2、更新商户地址信息 */
		Integer i = snoMerchantService.updateAddressInfo(merchant.getId(),address,bmapLoca);

		/** 3、将用户的入驻申请改成待审核 */
		Integer j = snoMerchantService.updateAuditStatus(merchant.getId(), 0 ,null, 1);



		return apiResultVO;
	}

	@GetMapping("getImageList")
	public ApiResultVO getImageList(@RequestParam("mid") Integer mid){
		ApiResultVO apiResultVO = new ApiResultVO();
		List<SnoMerchantImgPO> imageList = snoMerchantImgService.listByMerchantId(mid);
		apiResultVO.setData(imageList);

		return apiResultVO;
	}

	@GetMapping("listMerchantForAudit")
	public ApiResultVO listMerchatForAudit(@RequestParam("auditStatus") Integer auditStatus,
										   @RequestParam(value = "current", defaultValue = "1") Integer current,
										   @RequestParam(value = "rowCount", defaultValue = "10") Integer rowCount) {

		ApiResultVO apiResultVO = new ApiResultVO();

		Map<String, Object> paramMap = new HashMap<>();
		if(auditStatus!=0){
			paramMap.put("auditStatus",auditStatus);
		}
		paramMap.put("start",(current-1)*rowCount);
		paramMap.put("rowCount",rowCount);
		List<Map<String, Object>> list = snoMerchantService.listMerchant(paramMap);
		Integer total = snoMerchantService.getMerchantCountByMap(paramMap);

		HashMap<String, Object> resMap = new HashMap<>();

		resMap.put("list",list);
		resMap.put("total",total);

		apiResultVO.setData(resMap);
		return apiResultVO;
	}

    //	商户审核
	@GetMapping("auditMerchant")
	@Transactional
	public ApiResultVO auditMerchant(@RequestParam("merchantId") Integer merchantId,
									 @RequestParam("auditStatus") Integer auditStatus,
									 @RequestParam(value="auditFailMsg",required = false) String auditFailMsg){
		ApiResultVO apiResultVO = new ApiResultVO();

		SnoMerchantPO merchantPO = snoMerchantService.getById(merchantId);
		SnoUserPO user = snoUserService.getById(merchantPO.getUserId());


		if (auditStatus == 2) {	 //审核通过
			Integer i = snoMerchantService.updateAuditStatus(merchantId, 1, null,2);
			if (i > 0) {
				Map<String, String> paramMap = new HashMap<>();
				paramMap.put("openid",user.getOpenid());
				paramMap.put("merchant","1");
				Long j = snoUserService.updateByMap(paramMap);
				if (j > 0) {
					snoAllianceMerchantService.updateAfterAudit(merchantId);
					apiResultVO.setData(j);
				}
			}
		}
		if (auditStatus == 3) { // 审核拒绝
			Integer i = snoMerchantService.updateAuditStatus(merchantId, 1, auditFailMsg,3);
			if(i>0){
			    apiResultVO.setData(i);
            }
		}

		return apiResultVO;
	}

}
