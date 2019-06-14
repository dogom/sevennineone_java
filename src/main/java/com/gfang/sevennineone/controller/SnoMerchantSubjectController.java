package com.gfang.sevennineone.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoMerchantPO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoMerchantService;
import com.gfang.sevennineone.util.SnoUtil;
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
import com.gfang.sevennineone.model.po.SnoMerchantSubjectPO;
import com.gfang.sevennineone.service.SnoMerchantSubjectService;

/**
 * 机构课程表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoMerchant")
public class SnoMerchantSubjectController {
	@Autowired
	private SnoMerchantSubjectService snoMerchantSubjectService;
	@Autowired
	private SnoMerchantService snoMerchantService;

	@GetMapping("/listSubject")
	public ApiResultVO listSubject(@RequestParam("merchantId") Integer merchantId){
		ApiResultVO apiResultVO = new ApiResultVO();
		List<Map<String,Object>> maps = snoMerchantSubjectService.listSubject(merchantId);
		apiResultVO.setData(maps);
		return apiResultVO;
	}

	@PostMapping("/saveBatch")
	public ApiResultVO saveBatch(@RequestBody List<SnoMerchantSubjectPO> subjectPOList, @LoginUser SnoUserPO user) throws IOException {
		ApiResultVO apiResultVO = new ApiResultVO();
		/** 0、参数验证 */
		SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());
		/** 1、把之前的数据清空 */
		snoMerchantSubjectService.deleteBatchByMerchantId(merchant.getId());

		/** 2、保存信息 */
		for (SnoMerchantSubjectPO subject : subjectPOList) {
			subject.setmerchantId(merchant.getId());
			subject.setUserId(user.getId());
			subject.setStatus(1); //正常状态
			subject.setAdvImg(SnoUtil.downloadWxImage(subject.getAdvImg()));
			subject.setPrice(subject.getPrice() * 100);
		}
		Integer i = snoMerchantSubjectService.saveBatch(subjectPOList);

		/** 3、将用户的入驻申请改成待审核 */
		Integer j = snoMerchantService.updateAuditStatus(merchant.getId(), 0 , 1);

		apiResultVO.setData(i == subjectPOList.size() ? i : 0);
		return apiResultVO;
	}


	@GetMapping("listSubjectByToken")
	public ApiResultVO listSubjectByToken(@LoginUser SnoUserPO user){
		ApiResultVO apiResultVO = new ApiResultVO();
		List<Map<String,Object>> maps = snoMerchantSubjectService.listByUserId(user.getId());
		apiResultVO.setData(maps);
		return apiResultVO;
	}


	@PostMapping("/updateSubject")
	public ApiResultVO update(@RequestBody SnoMerchantSubjectPO po,@LoginUser SnoUserPO user) throws IOException {
		ApiResultVO apiResultVO = new ApiResultVO();
		Integer i = 0;
		if (po.getId() == null) {
			SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());

			po.setUserId(user.getId());
			po.setmerchantId(merchant.getId());
			po.setStatus(1);
			po.setAdvImg(SnoUtil.downloadWxImage(po.getAdvImg()));
			i = snoMerchantSubjectService.save(po);
		}else{
			i = snoMerchantSubjectService.update(po);
		}
		apiResultVO.setData(i);
		return apiResultVO;
	}


}
