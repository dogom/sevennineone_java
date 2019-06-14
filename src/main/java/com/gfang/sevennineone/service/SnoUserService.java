package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoUserPO;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoUserService {

    SnoUserPO getByOpenId(String openid);

    Map<String,Object> getMapByOpenid(String openid);

    Long saveByMap(Map<String, String> userinfoMap);

    Long updateByMap(Map<String, String> userinfoMap);

    SnoUserPO getById(String userId);

    Map<String,Object> getMapById(String userId);

    List<SnoUserPO> listByOpenids(String[] openids);

    Integer updatePhone(String phone,String userId);
}
