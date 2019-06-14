package com.gfang.sevennineone.controller;

import java.util.*;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoReplyPO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.model.vo.SnoDonationVO;
import com.gfang.sevennineone.service.SnoReplyService;
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
import com.gfang.sevennineone.model.po.SnoReplyDonationPO;
import com.gfang.sevennineone.service.SnoReplyDonationService;

/**
 * 报名助学表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
 
@RestController
@RequestMapping("snoReplyDonation")
public class SnoReplyDonationController {
	@Autowired
	private SnoReplyDonationService snoReplyDonationService;
	@Autowired
	private SnoReplyService snoReplyService;

	@GetMapping("/listDonationByReplyId")
	public ApiResultVO listDonationByReplyId(@RequestParam("replyId") Integer replyId,
											 @RequestParam(value = "current",defaultValue = "1") Integer current,
											 @RequestParam(value = "rowCount",defaultValue = "10") Integer rowCount){
		ApiResultVO apiResultVO = new ApiResultVO();
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("replyId",replyId);
		paramMap.put("current",current);
		paramMap.put("rowCount",rowCount);
		paramMap.put("start",(current-1)*rowCount);
		List<Map<String, Object>> donationList = snoReplyDonationService.listMapByReplyId(paramMap);
		Integer total = snoReplyDonationService.getCountByReplyId(paramMap);

		Map<String, Object> resMap = new HashMap<>();
		resMap.put("list",donationList);
		resMap.put("total",total);
		apiResultVO.setData(resMap);
		return apiResultVO;
	}

	
	/** 用户的助学记录 */
	@GetMapping("listDonationByUser")
	public ApiResultVO listDonationByUser(@LoginUser SnoUserPO user,
										  @RequestParam(value = "current",defaultValue = "1") Integer current,
										  @RequestParam(value = "rowCount",defaultValue = "10") Integer rowCount,
										  @RequestParam(value = "timeOption",defaultValue = "0") Integer timeOption,
										  @RequestParam(value = "orderOption",defaultValue = "0") Integer orderOption
										  ){
		ApiResultVO apiResultVO = new ApiResultVO();
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId",user.getId());
		paramMap.put("start",(current-1)*rowCount);
		paramMap.put("rowCount",rowCount);
		paramMap.put("timeOption",timeOption);
		paramMap.put("orderOption",orderOption);

		List<Map<String,Object>> data = snoReplyDonationService.listDonationByUser(paramMap);
		Integer total = snoReplyDonationService.getCountByUser(paramMap);

		if(total > 0){
			Set<Integer> set = new HashSet<>();
			for (Map<String, Object> map : data) {
				set.add((Integer)map.get("replyId"));
			}
			List<SnoReplyPO> replyList = snoReplyService.getByIds(set);
			for (Map<String, Object> donate : data) {
				for (SnoReplyPO reply : replyList) {
					if(((Integer)donate.get("replyId")).equals(reply.getId())){
						donate.put("childName",reply.getChildName());
						break;
					}
				}
			}
		}


		HashMap<String, Object> resMap = new HashMap<>();
		resMap.put("list",data);
		resMap.put("total",total);
		apiResultVO.setData(resMap);

		return apiResultVO;
	}


}
