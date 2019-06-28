package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.dao.SnoArticleDao;
import com.gfang.sevennineone.model.po.SnoArticlePO;
import com.gfang.sevennineone.service.SnoArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("SnoArticleService")
public class SnoArticleServiceImpl implements SnoArticleService {
	@Autowired
	private SnoArticleDao snoArticleDao;

	@Override
	public SnoArticlePO getById(Integer id) {
		return snoArticleDao.getById(id);
	}

	@Override
	public Integer save(SnoArticlePO po) {
		snoArticleDao.save(po);
		return po.getId();
	}

	@Override
	public List<SnoArticlePO> listByMap(Map<String, Object> paramMap) {
		return snoArticleDao.listByMap(paramMap);
	}

	@Override
	public Integer getCountByMap(Map<String, Object> paramMap) {
		return snoArticleDao.getCountByMap(paramMap);
	}

	@Override
	public void update(SnoArticlePO po) {
		snoArticleDao.update(po);
	}
}
