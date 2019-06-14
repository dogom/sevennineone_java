package com.gfang.sevennineone.controller;

import java.util.List;
import java.util.Map;

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
import com.gfang.sevennineone.model.po.SnoMerchantTeacherPO;
import com.gfang.sevennineone.service.SnoMerchantTeacherService;

/**
 * 机构师资表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoMerchantTeacher")
public class SnoMerchantTeacherController {
	@Autowired
	private SnoMerchantTeacherService snoMerchantTeacherService;

}
