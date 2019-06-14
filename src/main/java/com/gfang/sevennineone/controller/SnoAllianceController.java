package com.gfang.sevennineone.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoAllianceActivityPO;
import com.gfang.sevennineone.model.po.SnoAllianceMerchantPO;
import com.gfang.sevennineone.model.po.SnoMerchantSubjectPO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoAllianceActivityService;
import com.gfang.sevennineone.service.SnoAllianceMerchantService;
import com.gfang.sevennineone.service.SnoMerchantService;
import com.gfang.sevennineone.service.SnoMerchantSubjectService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		List<SnoAllianceMerchantPO> aMerchantList = snoAllianceMerchantService.listByParams(paramMap);
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
		List<Map<String, Object>> merchantMaps = snoMerchantService.listByIds(
				Lists.transform(snoAllianceMerchantPOS,
						input -> input.getMerchantId()
				).toArray(new Integer[snoAllianceMerchantPOS.size()])
		);

		merchantMaps.sort(new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				return (int)o1.get("hotNum") - (int)o2.get("hotNum") ;
			}
		});

		apiResultVO.setData(merchantMaps);

		return apiResultVO;
	}
}
