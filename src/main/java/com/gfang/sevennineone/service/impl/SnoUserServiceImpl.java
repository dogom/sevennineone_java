package com.gfang.sevennineone.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.gfang.sevennineone.dao.SnoUserDao;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoUserService;



@Service("SnoUserService")
public class SnoUserServiceImpl implements SnoUserService {
	@Autowired
	private SnoUserDao snoUserDao;
	private Gson gson = new Gson();

	@Override
	public SnoUserPO getByOpenId(String openid) {
		return snoUserDao.getByOpenId(openid);
	}

	@Override
	public Map<String, Object> getMapByOpenid(String openid) {
		return snoUserDao.getMapByOpenid(openid);
	}

	@Override
	public Long saveByMap(Map<String, String> userinfoMap) {
		userinfoMap.put("id", UUID.randomUUID().toString().replace("-",""));
		userinfoMap.put("privilege",gson.toJson(userinfoMap.get("privilege")));
		return snoUserDao.save(userinfoMap);
	}

	@Override
	public Long updateByMap(Map<String, String> userinfoMap) {
		return snoUserDao.updateByMap(userinfoMap);
	}

	@Override
	public SnoUserPO getById(String userId) {
		return snoUserDao.getById(userId);
	}

	@Override
	public Map<String, Object> getMapById(String userId) {
		return snoUserDao.getMapById(userId);
	}

	@Override
	public List<SnoUserPO> listByOpenids(String[] openids) {
		return snoUserDao.listByOpenids(openids);
	}

	@Override
	public Integer updatePhone(String phone,String userId) {
		return snoUserDao.updatePhone(phone,userId);
	}
}
