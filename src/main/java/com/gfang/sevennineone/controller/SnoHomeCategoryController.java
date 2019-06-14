package com.gfang.sevennineone.controller;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoGiftPO;
import com.gfang.sevennineone.model.po.SnoHomeCategoryPO;
import com.gfang.sevennineone.service.SnoGiftService;
import com.gfang.sevennineone.service.SnoHomeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页菜单表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("common")
public class SnoHomeCategoryController {
	@Autowired
	private SnoHomeCategoryService snoHomeCategoryService;

	@GetMapping("/getHomeData")
	public ApiResultVO getHomeData(){
		ApiResultVO apiResultVO = new ApiResultVO();
		List<SnoHomeCategoryPO> categoryList = snoHomeCategoryService.listHomeCategory();
		ArrayList<Map<String, Object>> result = new ArrayList<>();
		for (SnoHomeCategoryPO categoryPO : categoryList) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("imgUrl",categoryPO.getUrl());
			map.put("text",categoryPO.getName());
			map.put("id",categoryPO.getId());
			result.add(map);
		}
		apiResultVO.setData(result);
		return apiResultVO;
	}



}
