package com.gfang.sevennineone.service;

import com.gfang.sevennineone.dao.SnoActivityPrizeDao;
import com.gfang.sevennineone.dao.SnoChildDao;
import com.gfang.sevennineone.model.po.SnoActivityPrizePO;
import com.gfang.sevennineone.model.po.SnoChildPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("SnoActivityPrizeService")
public class SnoActivityPrizeServiceImpl implements SnoActivityPrizeService {
	@Autowired
	private SnoActivityPrizeDao snoActivityPrizeDao;

	@Override
	public SnoChildPO getById(Integer id) {
		return snoActivityPrizeDao.getById(id);
	}

	@Override
	public Integer save(SnoActivityPrizePO po) {
		snoActivityPrizeDao.save(po);
		return po.getId();
	}

	@Override
	public Integer update(SnoActivityPrizePO po) {
		return snoActivityPrizeDao.update(po);
	}

	@Override
	public List<SnoActivityPrizePO> listByMap(Map<String, Object> map) {
		return snoActivityPrizeDao.listByMap(map);
	}

	@Override
	public Integer getCountByMap(Map<String, Object> map) {
		return snoActivityPrizeDao.getCountByMap(map);
	}
}
