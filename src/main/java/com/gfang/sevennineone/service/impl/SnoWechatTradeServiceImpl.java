package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.dao.SnoGiftDao;
import com.gfang.sevennineone.dao.SnoWechatTradeDao;
import com.gfang.sevennineone.model.po.SnoGiftPO;
import com.gfang.sevennineone.model.po.SnoWechatTradePO;
import com.gfang.sevennineone.service.SnoGiftService;
import com.gfang.sevennineone.service.SnoWechatTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("SnoWechatTradeService")
public class SnoWechatTradeServiceImpl implements SnoWechatTradeService {

	@Autowired
	private SnoWechatTradeDao snoWechatTradeDao;

	@Override
	public Integer save(SnoWechatTradePO po) {
		snoWechatTradeDao.save(po);
		return po.getId();
	}

	@Override
	public SnoWechatTradePO getById(Integer giftId) {
		return snoWechatTradeDao.getById(giftId);
	}

	@Override
	public Integer updateTradeSuccess(Map<String, String> wechatNotifyMap) {
		return snoWechatTradeDao.updateTradeSuccess(wechatNotifyMap);
	}
}
