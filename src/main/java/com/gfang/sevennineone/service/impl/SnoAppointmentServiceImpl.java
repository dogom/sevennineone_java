package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.dao.SnoAppointmentDao;
import com.gfang.sevennineone.dao.SnoGiftDao;
import com.gfang.sevennineone.model.po.SnoAppointmentPO;
import com.gfang.sevennineone.model.po.SnoGiftPO;
import com.gfang.sevennineone.service.SnoAppointmentService;
import com.gfang.sevennineone.service.SnoGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("SnoAppointmentService")
public class SnoAppointmentServiceImpl implements SnoAppointmentService {

	@Autowired
	private SnoAppointmentDao snoAppointmentDao;

	@Override
	public SnoAppointmentPO getById(Integer id) {
		return snoAppointmentDao.getById(id);
	}

	@Override
	public Integer save(SnoAppointmentPO po) {
		snoAppointmentDao.save(po);
		return po.getId();
	}

	@Override
	public List<SnoAppointmentPO> listByUserId(String userId) {
		return snoAppointmentDao.listByUserId(userId);
	}

	@Override
	public List<SnoAppointmentPO> listByMerchantId(Integer merchantId) {
		return snoAppointmentDao.listByMerchantId(merchantId);
	}

	@Override
	public Integer updateStatus(Integer fromStatus, Integer toStatus, Integer id) {
		return snoAppointmentDao.updateStatus(fromStatus,toStatus,id);
	}
}
