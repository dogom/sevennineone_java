package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.dao.SnoActivityLinkDao;
import com.gfang.sevennineone.dao.SnoArticleDao;
import com.gfang.sevennineone.model.po.SnoActivityLinkPO;
import com.gfang.sevennineone.model.po.SnoArticlePO;
import com.gfang.sevennineone.service.SnoActivityLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SnoActivityLinkService")
public class SnoActivityLinkServiceImpl implements SnoActivityLinkService {
	@Autowired
	private SnoActivityLinkDao snoActivityLinkDao;

	@Override
	public SnoActivityLinkPO getById(Integer id) {
		return snoActivityLinkDao.getById(id);
	}

	@Override
	public Integer save(SnoActivityLinkPO po) {
		return snoActivityLinkDao.save(po);
	}

	@Override
	public List<SnoActivityLinkPO> listByActivityId(Integer id) {
		return snoActivityLinkDao.listByActivityId(id);
	}

	@Override
	public void update(SnoActivityLinkPO po) {
		snoActivityLinkDao.update(po);
	}

	@Override
	public Integer delete(Integer id) {
		return snoActivityLinkDao.delete(id);
	}
}
