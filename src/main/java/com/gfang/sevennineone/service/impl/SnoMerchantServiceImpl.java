package com.gfang.sevennineone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.dao.SnoMerchantDao;
import com.gfang.sevennineone.model.po.SnoMerchantPO;
import com.gfang.sevennineone.service.SnoMerchantService;



@Service("SnoMerchantService")
public class SnoMerchantServiceImpl implements SnoMerchantService {
	@Autowired
	private SnoMerchantDao snoMerchantDao;

	@Override
	public List<Map<String, Object>> listMerchant(Map<String,Object> map) {
		return snoMerchantDao.listMerchant(map);
	}

	@Override
	public SnoMerchantPO getById(Integer id) {
		return snoMerchantDao.getById(id);
	}

	@Override
	public Map<String,Object> getMerchantById(Integer id) {
		return snoMerchantDao.getMerchantById(id);
	}

	@Override
	public List<Map<String, Object>> listByIds(Integer[] ids) {
		return snoMerchantDao.listByIds(ids);
	}

	@Override
	public void updateReplyCountAddOne(Integer merchantId) {
		snoMerchantDao.updateReplyCountAddOne(merchantId);
	}

	@Override
	public Integer save(SnoMerchantPO po) {
		Integer i = snoMerchantDao.save(po);
		return i > 0 ? po.getId() : 0;
	}

	@Override
	public SnoMerchantPO getByUserId(String userId) {
		return snoMerchantDao.getByUserId(userId);
	}

	@Override
	public Integer update(SnoMerchantPO po) {
		return snoMerchantDao.update(po);
	}

	@Override
	public Integer updateAuditStatus(Integer merchantId, Integer fromStatus, Integer toStatus) {
		return snoMerchantDao.updateAuditStatus(merchantId, fromStatus, toStatus);
	}
}
