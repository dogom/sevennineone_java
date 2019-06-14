package com.gfang.sevennineone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.common.SmsUtil;
import com.gfang.sevennineone.model.po.SnoSmsDetailPO;
import com.gfang.sevennineone.service.SnoSmsDetailService;
import com.google.gson.Gson;
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
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoUserService;

/**
 * 用户表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoUser")
public class SnoUserController {
	@Autowired
	private SnoUserService snoUserService;
	@Autowired
	private SnoSmsDetailService snoSmsDetailService;

	// 发送短信验证码
	@GetMapping("sendSms")
	public ApiResultVO sendSms(@RequestParam("phoneNum") String phoneNum){
		ApiResultVO apiResultVO = new ApiResultVO();
		Random random = new Random();
		String signName = "趣教育";
		String codeTemplate = "SMS_117085077";
		String param = "{\"code\":\"123456\"}".replace("123456",String.valueOf(random.nextInt(899999) + 100000));
		SmsUtil.sendSms(phoneNum,param,signName,codeTemplate);
		Integer smsId = snoSmsDetailService.save(new SnoSmsDetailPO(signName, codeTemplate, param));
		apiResultVO.setData(smsId);
		return apiResultVO;
	}

	// 绑定手机号
	@GetMapping("bindPhone")
	public ApiResultVO bindPhone(@LoginUser SnoUserPO user,@RequestParam("smsId") Integer smsId,@RequestParam("smsCode") String code,@RequestParam("phoneNum") String phoneNum){
		ApiResultVO apiResultVO = new ApiResultVO();
		SnoSmsDetailPO sms = snoSmsDetailService.getById(smsId);
		Gson gson = new Gson();
		HashMap<String, String> map = gson.fromJson(sms.getParam(), HashMap.class);
		if (!map.get("code").equals(code)) {
			apiResultVO.setCode(-1);
			apiResultVO.setMessage("验证码错误");
		}else{
			Integer i = snoUserService.updatePhone(phoneNum, user.getId());
			if(i==0){
				apiResultVO.setCode(-1);
				apiResultVO.setMessage("绑定失败");
			}
		}
		return apiResultVO;
	}

	// 查询用户手机号
	@GetMapping("getMobileInfo")
	public ApiResultVO getMobileInfo(@LoginUser SnoUserPO user){
		ApiResultVO apiResultVO = new ApiResultVO();

		String mobileNum = user.getMobile();
		if(mobileNum!=null){
			apiResultVO.setData(mobileNum.substring(0,3)+"****"+mobileNum.substring(7));
		}

		return apiResultVO;
	}
}
