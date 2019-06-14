package com.gfang.sevennineone.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoAllianceMerchantPO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoAllianceMerchantService;
import com.gfang.sevennineone.service.SnoMerchantSubjectService;
import com.gfang.sevennineone.util.SnoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.gfang.sevennineone.model.po.SnoMerchantPO;
import com.gfang.sevennineone.service.SnoMerchantService;

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

	@GetMapping("/listMerchant")
	public ApiResultVO listMerchant(@RequestParam(value="categoryId",required = false) Integer categoryId,
									@RequestParam(value="province",required = false) String province,
									@RequestParam(value="city",required = false) String city,
									@RequestParam(value="area",required = false) String area,
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
		List<Map<String, Object>> maps = snoMerchantService.listMerchant(paramMap);
		apiResultVO.setData(maps);
		return apiResultVO;
	}

	@GetMapping("/seller")
	public ApiResultVO seller(@RequestParam("id") Integer id,@RequestParam(value = "aid",required = false) Integer aid){
		ApiResultVO apiResultVO = new ApiResultVO();
		Map<String,Object> po = snoMerchantService.getMerchantById(id);
		if (aid != null) {
			Map<String,Object> aMerchant = snoAllianceMerchantService.getByAidAndMid(aid,id);
			po.put("experienceNum",aMerchant.get("experienceNum"));
		}
		List<Map<String, Object>> subjectList = snoMerchantSubjectService.listSubject(id);
		po.put("subjectList",subjectList);
		apiResultVO.setData(po);
		return apiResultVO;
	}

	@PostMapping("/save")
	public ApiResultVO save(@RequestBody SnoMerchantPO po, @LoginUser SnoUserPO user) throws IOException {
		ApiResultVO apiResultVO = new ApiResultVO();
		if (user == null) {
			apiResultVO.setCode(-1);
			apiResultVO.setMessage("用户未登录");
		} else {
			logger.info("商家入驻数据：{}", po);

			SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());
			po.setLogo(SnoUtil.downloadWxImage(po.getLogo()));
			po.setBusinessLicense(SnoUtil.downloadWxImage(po.getBusinessLicense()));
			if (merchant == null) {
				po.setUserId(user.getId());
				po.setAuditStatus(0);
				Integer merchantId = snoMerchantService.save(po);
				apiResultVO.setData(merchantId);
			}else{
				po.setId(merchant.getId());
				snoMerchantService.update(po);
				apiResultVO.setData(merchant.getId());
			}
		}

		return apiResultVO;
	}

	@GetMapping("/getMerchantJoinInfo")
	public ApiResultVO getMerchantJoinInfo(@LoginUser SnoUserPO user) {
		ApiResultVO apiResultVO = new ApiResultVO();
		SnoMerchantPO merchantPO = null;
		if (user != null) {
			merchantPO = snoMerchantService.getByUserId(user.getId());
		}
		apiResultVO.setData(merchantPO);
		return apiResultVO;
	}

}
