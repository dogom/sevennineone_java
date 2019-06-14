package com.gfang.sevennineone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.dao.SnoReplyDonationDao;
import com.gfang.sevennineone.model.po.SnoReplyDonationPO;
import com.gfang.sevennineone.service.SnoReplyDonationService;



@Service("SnoReplyDonationService")
public class SnoReplyDonationServiceImpl implements SnoReplyDonationService {
	@Autowired
	private SnoReplyDonationDao snoReplyDonationDao;

	@Override
	public List<Map<String, Object>> listMapByReplyId(Map<String, Object> map) {
		return snoReplyDonationDao.listMapByReplyId(map);
	}

	@Override
	public Integer save(SnoReplyDonationPO po) {
		Integer i = snoReplyDonationDao.save(po);
		return i > 0 ? po.getId() : 0;
	}

	@Override
	public Integer getCountByReplyId(HashMap<String, Object> paramMap) {
		return snoReplyDonationDao.getCountByReplyId(paramMap);
	}

	@Override
	public Integer updateDonateSuccess(Map<String, String> wechatNotifyMap) {
		return snoReplyDonationDao.updateDonateSuccess(wechatNotifyMap);
	}

	@Override
	public SnoReplyDonationPO getByOutTradeNo(String outTradeNo) {
		return snoReplyDonationDao.getByOutTradeNo(outTradeNo);
	}

	@Override
	public List<Map<String, Object>> listDonationByUser(Map<String, Object> paramMap) {
		return snoReplyDonationDao.listDonationByUser(paramMap);
	}

	@Override
	public Integer getCountByUser(Map<String, Object> paramMap) {
		return snoReplyDonationDao.getCountByUser(paramMap);
	}
}
