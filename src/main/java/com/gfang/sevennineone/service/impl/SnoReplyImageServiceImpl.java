package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.dao.SnoReplyImageDao;
import com.gfang.sevennineone.model.po.SnoReplyImagePO;
import com.gfang.sevennineone.model.po.SnoReplyPO;
import com.gfang.sevennineone.service.SnoReplyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("SnoReplyImageService")
public class SnoReplyImageServiceImpl implements SnoReplyImageService {
	@Autowired
	private SnoReplyImageDao snoReplyImageDao;

	@Override
	public Long save(SnoReplyImagePO po) {
		return snoReplyImageDao.save(po);
	}

	@Override
	public List<SnoReplyImagePO> listByReplyId(Integer replyId) {
		return snoReplyImageDao.listByReplyId(replyId);
	}

	@Override
	public List<SnoReplyImagePO> listByReplyIds(Integer[] replyIds) {
		return snoReplyImageDao.listByReplyIds(replyIds);
	}
}
