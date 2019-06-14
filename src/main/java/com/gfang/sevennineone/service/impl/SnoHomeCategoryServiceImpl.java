package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.dao.SnoHomeCategoryDao;
import com.gfang.sevennineone.model.po.SnoHomeCategoryPO;
import com.gfang.sevennineone.service.SnoGiftService;
import com.gfang.sevennineone.service.SnoHomeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SnoHomeCategoryService")
public class SnoHomeCategoryServiceImpl implements SnoHomeCategoryService {

	@Autowired
	private SnoHomeCategoryDao snoHomeCategoryDao;

	@Override
	public ApiResultVO add(SnoHomeCategoryPO po) {
		long i = snoHomeCategoryDao.save(po);
		return new ApiResultVO();
	}

	@Override
	public List<SnoHomeCategoryPO> listHomeCategory() {
		return snoHomeCategoryDao.listHomeCategory();
	}
}
