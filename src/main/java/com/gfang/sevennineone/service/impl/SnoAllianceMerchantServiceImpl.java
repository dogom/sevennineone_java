package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.dao.SnoAllianceMerchantDao;
import com.gfang.sevennineone.model.po.SnoAllianceActivityPO;
import com.gfang.sevennineone.model.po.SnoAllianceMerchantPO;
import com.gfang.sevennineone.service.SnoAllianceMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("SnoAllianceMerchantService")
public class SnoAllianceMerchantServiceImpl implements SnoAllianceMerchantService {

	@Autowired
	private SnoAllianceMerchantDao snoAllianceMerchantDao;

	@Override
	public ApiResultVO save(SnoAllianceMerchantPO po) {
		long i = snoAllianceMerchantDao.save(po);
		return new ApiResultVO();
	}

	@Override
	public SnoAllianceMerchantPO getById(Integer id) {
		return snoAllianceMerchantDao.getById(id);
	}

	@Override
	public List<SnoAllianceMerchantPO> listByParams(Map<String, Object> map) {
		return snoAllianceMerchantDao.listByParams(map);
	}

	@Override
	public Map<String, Object> getByAidAndMid(Integer aid, Integer mid) {
		return snoAllianceMerchantDao.getByAidAndMid(aid,mid);
	}
}
