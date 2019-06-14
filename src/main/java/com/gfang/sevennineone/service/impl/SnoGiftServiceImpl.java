package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.common.ApiResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.dao.SnoGiftDao;
import com.gfang.sevennineone.model.po.SnoGiftPO;
import com.gfang.sevennineone.service.SnoGiftService;



@Service("SnoGiftService")
public class SnoGiftServiceImpl implements SnoGiftService {

	@Autowired
	private SnoGiftDao snoGiftDao;

	@Override
	public ApiResultVO add(SnoGiftPO po) {
		long i = snoGiftDao.save(po);
		return new ApiResultVO();
	}

	@Override
	public List<Map<String, Object>> listMapGift() {
		return snoGiftDao.listMapGift();
	}

	@Override
	public SnoGiftPO getById(Integer giftId) {
		return snoGiftDao.getById(giftId);
	}
}
