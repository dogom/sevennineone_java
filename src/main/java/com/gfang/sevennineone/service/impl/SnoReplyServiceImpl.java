package com.gfang.sevennineone.service.impl;

import com.gfang.sevennineone.dao.SnoMerchantDao;
import com.gfang.sevennineone.dao.SnoMerchantSubjectDao;
import com.gfang.sevennineone.service.SnoMerchantService;
import com.gfang.sevennineone.service.SnoMerchantSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gfang.sevennineone.dao.SnoReplyDao;
import com.gfang.sevennineone.model.po.SnoReplyPO;
import com.gfang.sevennineone.service.SnoReplyService;
import org.springframework.transaction.annotation.Transactional;


@Service("SnoReplyService")
public class SnoReplyServiceImpl implements SnoReplyService {
	@Autowired
	private SnoReplyDao snoReplyDao;
	@Autowired
	private SnoMerchantSubjectService snoMerchantSubjectService;
	@Autowired
	private SnoMerchantService snoMerchantService;

	@Override
	public List<Map<String, Object>> getByOpenidAndMerchantId(String openid,Integer activityId , Integer merchantId) {
		return snoReplyDao.getByOpenidAndMerchantId(openid, activityId,merchantId);
	}

	@Override
	public List<Map<String, Object>> listReplyByMap(Map<String, Object> paramMap) {
		return snoReplyDao.listReplyByMap(paramMap);
	}

	@Override
	public Long getReplyCountByMap(Map<String, Object> paramMap) {
		return snoReplyDao.getReplyCountByMap(paramMap);
	}

	@Override
	@Transactional
	public Long save(SnoReplyPO snoReplyPO) {
		Long i = snoReplyDao.save(snoReplyPO);
		snoMerchantSubjectService.updateRealStudentAddOne(snoReplyPO.getSubjectId());
		snoMerchantService.updateReplyCountAddOne(snoReplyPO.getMerchantId());
		return i > 0 ? snoReplyPO.getId().longValue() : 0;
	}

	@Override
	public Map<String, Object> getMapById(Integer replyId) {
		return snoReplyDao.getMapById(replyId);
	}

	@Override
	public Integer updatePaidFee(Integer newAddNum,Integer replyId) {
		return snoReplyDao.updatePaidFee(newAddNum,replyId);
	}

	@Override
	public List<Map<String, Object>> listReplyByUser(String openid,Integer start,Integer rowCount) {
		return snoReplyDao.listReplyByUser(openid,start, rowCount);
	}

	@Override
	public Integer getUserReplyCount(String openid) {
		return snoReplyDao.getUserReplyCount(openid);
	}

	@Override
	public List<SnoReplyPO> getByIds(Set<Integer> set) {
		return snoReplyDao.getByIds(set);
	}

	@Override
	public List<Integer> listAppointmentA(String openid) {
		return snoReplyDao.listAppointmentA(openid);
	}
}
