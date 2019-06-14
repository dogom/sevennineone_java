package com.gfang.sevennineone.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gfang.sevennineone.model.po.SnoUserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoUserDao{

	SnoUserPO getById(String id);

    SnoUserPO getByOpenId(String openid);

    Map<String,Object> getMapByOpenid(String openid);

    long save(Map<String,String> map);

    Long updateByMap(Map<String,String> map);

    Map<String,Object> getMapById(String id);

    List<SnoUserPO> listByOpenids(String[] openids);

    Integer updatePhone(@Param("phone") String phone,@Param("userId") String userId);
}
