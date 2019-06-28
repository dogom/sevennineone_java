package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoAllianceActivityPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动表
 * Created by Administrator on 2019/5/10.
 */
@Mapper
public interface SnoAllianceActivityDao {
    SnoAllianceActivityPO getById(Integer id);

    Integer save(SnoAllianceActivityPO po);
    List<Map<String,Object>> listByIds(Integer[] ids);

    Integer getListActivityCount(HashMap<String, Object> paramMap);

    List<Map<String,Object>> listActivity(HashMap<String, Object> paramMap);

    Integer getActivityCountByMap(HashMap<String, Object> paramMap);

    Map<String,Object> getMapById(Integer id);

    Integer updateForAudit(Map<String, Object> paramMap);

    void update(SnoAllianceActivityPO activityPO);
}
