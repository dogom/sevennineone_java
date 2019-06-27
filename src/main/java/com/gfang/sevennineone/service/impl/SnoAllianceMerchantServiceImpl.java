package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.dao.SnoAllianceMerchantDao;
import com.gfang.sevennineone.model.po.SnoAllianceActivityPO;
import com.gfang.sevennineone.model.po.SnoAllianceMerchantPO;
import com.gfang.sevennineone.service.SnoAllianceMerchantService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("SnoAllianceMerchantService")
public class SnoAllianceMerchantServiceImpl implements SnoAllianceMerchantService {

	@Autowired
	private SnoAllianceMerchantDao snoAllianceMerchantDao;

	@Override
	public Integer save(SnoAllianceMerchantPO po) {
		Integer i = snoAllianceMerchantDao.save(po);
		return i;
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

	@Override
	public Map<String, Object> getExistsByAidAndMid(Integer aid, Integer mid) {
		return snoAllianceMerchantDao.getExistsByAidAndMid(aid,mid);
	}

	@Override
	public void updateAfterAudit(Integer merchantId) {
		snoAllianceMerchantDao.updateAfterAudit(merchantId);
	}

	@Override
	public void updateReplyCount(Integer activityId, Integer merchantId) {
		snoAllianceMerchantDao.updateReplyCount(activityId,merchantId);
	}

	@Override
	public List<Map<String, Object>> listMerchantForSearch(Map<String,Object> map) {
		return snoAllianceMerchantDao.listMerchantForSearch(map);
	}
}
