package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.dao.SnoAllianceActivityDao;
import com.gfang.sevennineone.model.po.SnoAllianceActivityPO;
import com.gfang.sevennineone.service.SnoAllianceActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("SnoAllianceActivityService")
public class SnoAllianceActivityServiceImpl implements SnoAllianceActivityService {

	@Autowired
	private SnoAllianceActivityDao snoAllianceActivityDao;

	@Override
	public Integer save(SnoAllianceActivityPO po) {
		Integer i = snoAllianceActivityDao.save(po);
		return po.getId();
	}

	@Override
	public SnoAllianceActivityPO getById(Integer id) {
		return snoAllianceActivityDao.getById(id);
	}

	@Override
	public List<Map<String, Object>> listByIds(Integer[] ids) {
		return snoAllianceActivityDao.listByIds(ids);
	}

	@Override
	public Integer getListActivityCount(HashMap<String, Object> paramMap) {
		return snoAllianceActivityDao.getListActivityCount(paramMap);
	}

	@Override
	public List<Map<String, Object>> listActivity(HashMap<String, Object> paramMap) {
		return snoAllianceActivityDao.listActivity(paramMap);
	}

	@Override
	public Map<String, Object> getMapById(Integer id) {
		return snoAllianceActivityDao.getMapById(id);
	}

	@Override
	public Integer getActivityCountByMap(HashMap<String, Object> paramMap) {
		return snoAllianceActivityDao.getActivityCountByMap(paramMap);
	}

	@Override
	public Integer updateForAudit(Map<String, Object> paramMap) {
		return snoAllianceActivityDao.updateForAudit(paramMap);
	}

	@Override
	public void update(SnoAllianceActivityPO activityPO) {
		snoAllianceActivityDao.update(activityPO);
	}
}
