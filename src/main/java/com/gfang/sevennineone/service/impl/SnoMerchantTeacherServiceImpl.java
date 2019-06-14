package com.gfang.sevennineone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.dao.SnoMerchantTeacherDao;
import com.gfang.sevennineone.model.po.SnoMerchantTeacherPO;
import com.gfang.sevennineone.service.SnoMerchantTeacherService;



@Service("SnoMerchantTeacherService")
public class SnoMerchantTeacherServiceImpl implements SnoMerchantTeacherService {
	@Autowired
	private SnoMerchantTeacherDao snoMerchantTeacherDao;
	 
}
