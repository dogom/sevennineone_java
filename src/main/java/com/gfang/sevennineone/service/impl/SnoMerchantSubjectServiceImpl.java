package com.gfang.sevennineone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gfang.sevennineone.dao.SnoMerchantSubjectDao;
import com.gfang.sevennineone.model.po.SnoMerchantSubjectPO;
import com.gfang.sevennineone.service.SnoMerchantSubjectService;



@Service("SnoMerchantSubjectService")
public class SnoMerchantSubjectServiceImpl implements SnoMerchantSubjectService {
	@Autowired
	private SnoMerchantSubjectDao snoMerchantSubjectDao;

	@Override
	public List<Map<String, Object>> listSubject(Integer merchantId) {
		return snoMerchantSubjectDao.listSubject(merchantId);
	}

	@Override
	public SnoMerchantSubjectPO getById(Integer subjectId) {
		return snoMerchantSubjectDao.getById(subjectId);
	}

	@Override
	public void updateRealStudentAddOne(Integer subjectId) {
		snoMerchantSubjectDao.updateRealStudentAddOne(subjectId);
	}

	@Override
	public Integer saveBatch(List<SnoMerchantSubjectPO> subjectPOList) {
		return snoMerchantSubjectDao.saveBatch(subjectPOList);
	}

	@Override
	public List<Map<String, Object>> listByUserId(String id) {
		return snoMerchantSubjectDao.listByUserId(id);
	}

	@Override
	public void deleteBatchByMerchantId(Integer merchantId) {
		snoMerchantSubjectDao.deleteBatchByMerchantId(merchantId);
	}

	@Override
	public Integer save(SnoMerchantSubjectPO po) {
		return snoMerchantSubjectDao.save(po);
	}

	@Override
	public Integer update(SnoMerchantSubjectPO po) {
		return snoMerchantSubjectDao.update(po);
	}

	@Override
	public List<SnoMerchantSubjectPO> listByMerchantIds(Integer[] merchantIds) {
		return snoMerchantSubjectDao.listByMerchantIds(merchantIds);
	}

	@Override
	public List<SnoMerchantSubjectPO> listByIds(Integer[] ids) {
		return snoMerchantSubjectDao.listByIds(ids);
	}
	@Override
	public Integer deleteSubject(Integer sid) {
		return snoMerchantSubjectDao.deleteSubject(sid);
	}
}
