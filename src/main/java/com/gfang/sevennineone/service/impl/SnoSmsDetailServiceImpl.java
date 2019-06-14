package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.dao.SnoChildDao;
import com.gfang.sevennineone.dao.SnoSmsDetailDao;
import com.gfang.sevennineone.model.po.SnoSmsDetailPO;
import com.gfang.sevennineone.service.SnoChildService;
import com.gfang.sevennineone.service.SnoSmsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SnoSmsDetailService")
public class SnoSmsDetailServiceImpl implements SnoSmsDetailService {
	@Autowired
	private SnoSmsDetailDao snoSmsDetailDao;

	@Override
	public SnoSmsDetailPO getById(Integer id) {
		return snoSmsDetailDao.getById(id);
	}

	@Override
	public Integer save(SnoSmsDetailPO po) {
		snoSmsDetailDao.save(po);
		return po.getId();
	}
}
