package com.gfang.sevennineone.controller;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.*;
import com.gfang.sevennineone.service.*;
import com.gfang.sevennineone.util.SnoUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoAppointment")
public class SnoAppointmentController {
	@Autowired
	private SnoAppointmentService snoAppointmentService;
	@Autowired
	private SnoAllianceActivityService snoAllianceActivityService;
	@Autowired
	private SnoMerchantService snoMerchantService;
	@Autowired
	private SnoMerchantSubjectService snoMerchantSubjectService;
	@Autowired
	private SnoUserService snoUserService;

	@PostMapping("save")
	public ApiResultVO add(@LoginUser SnoUserPO user,@RequestBody SnoAppointmentPO po){
		ApiResultVO apiResultVO = new ApiResultVO();
		po.setUserId(user.getId());
		po.setNickName(user.getNickname());
		// 查找活动名
		SnoAllianceActivityPO activity = snoAllianceActivityService.getById(po.getActivityId());
		po.setActivityName(activity.getName());
		// 查找商家名
		SnoMerchantPO merchant = snoMerchantService.getById(po.getMerchantId());
		po.setMerchantName(merchant.getName());
		// 查找课程名
		SnoMerchantSubjectPO subject = snoMerchantSubjectService.getById(po.getSubjectId());
		po.setSubjectName(subject.getName());
		po.setAppointmentCode(SnoUtil.getRandomString(32));


		Integer id = snoAppointmentService.save(po);
		apiResultVO.setData(id);
		return apiResultVO;
	}

	@GetMapping("listByUserId")
	public ApiResultVO listGift(@LoginUser SnoUserPO user,@RequestParam("isMerchant") Boolean isMerchant){
		ApiResultVO apiResultVO = new ApiResultVO();
		List<SnoAppointmentPO> list = null;
		if(isMerchant){
			SnoMerchantPO merchant = snoMerchantService.getByUserId(user.getId());
			list = snoAppointmentService.listByMerchantId(merchant.getId());
		}else{
			list=  snoAppointmentService.listByUserId(user.getId());
		}
		apiResultVO.setData(list);
		return apiResultVO;
	}

	@GetMapping("cancelAppointment")
	public ApiResultVO cancelAppointment(@LoginUser SnoUserPO user,@RequestParam("id") Integer id){
		ApiResultVO apiResultVO = new ApiResultVO();

		SnoAppointmentPO appointment = snoAppointmentService.getById(id);
		if(appointment.getUserId().equals(user.getId())){
			Integer i = snoAppointmentService.updateStatus(0,2,id);
			apiResultVO.setCode(i > 0 ? 0 : -1);
		}else{
			apiResultVO.setCode(-1);
			apiResultVO.setMessage("您没有操作权限");
		}

		return apiResultVO;
	}

	@GetMapping("getMobile")
	public ApiResultVO getMobile(@LoginUser SnoUserPO user,@RequestParam("id") Integer id){
		ApiResultVO apiResultVO = new ApiResultVO();
		SnoAppointmentPO appointment = snoAppointmentService.getById(id);
		Map<String, Object> merchant = snoMerchantService.getMerchantById(appointment.getMerchantId());
		if(merchant.get("user_id").equals(user.getId())){
			SnoUserPO clientUser = snoUserService.getById(appointment.getUserId());
			apiResultVO.setData(clientUser.getMobile());
		}

		return apiResultVO;
	}
}
