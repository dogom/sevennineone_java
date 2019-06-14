package com.gfang.sevennineone.controller;

import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.common.ApiResultVO;
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
import com.gfang.sevennineone.model.po.SnoGiftPO;
import com.gfang.sevennineone.service.SnoGiftService;

/**
 * 礼物表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("gift")
public class SnoGiftController {
	@Autowired
	private SnoGiftService snoGiftService;

	@PostMapping("add")
	public ApiResultVO add(@RequestBody SnoGiftPO po){
		return snoGiftService.add(po);
	}

	@GetMapping("listGift")
	public ApiResultVO listGift(){
		ApiResultVO apiResultVO = new ApiResultVO();
		List<Map<String,Object>> list = snoGiftService.listMapGift();
		apiResultVO.setData(list);
		return apiResultVO;
	}
}
