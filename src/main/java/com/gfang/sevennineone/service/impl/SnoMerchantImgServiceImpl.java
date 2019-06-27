package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.dao.SnoMerchantImgDao;
import com.gfang.sevennineone.model.po.SnoMerchantImgPO;
import com.gfang.sevennineone.service.SnoMerchantImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SnoMerchantImgService")
public class SnoMerchantImgServiceImpl implements SnoMerchantImgService {
	@Autowired
	private SnoMerchantImgDao snoMerchantImgDao;

	@Override
	public SnoMerchantImgPO getById(Integer id) {
		return snoMerchantImgDao.getById(id);
	}

	@Override
	public List<SnoMerchantImgPO> listByMerchantId(Integer mid) {
		return snoMerchantImgDao.listByMerchantId(mid);
	}

	@Override
	public Integer saveBatch(List<SnoMerchantImgPO> poList) {
		return snoMerchantImgDao.saveBatch(poList);
	}
}
