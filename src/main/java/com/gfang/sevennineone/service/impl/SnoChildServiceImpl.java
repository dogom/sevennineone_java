package com.gfang.sevennineone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.dao.SnoChildDao;
import com.gfang.sevennineone.model.po.SnoChildPO;
import com.gfang.sevennineone.service.SnoChildService;



@Service("SnoChildService")
public class SnoChildServiceImpl implements SnoChildService {
	@Autowired
	private SnoChildDao snoChildDao;
	 
}
