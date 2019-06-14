package com.gfang.sevennineone.service;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoAllianceActivityPO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 联盟活动表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoAllianceActivityService {

    ApiResultVO save(SnoAllianceActivityPO po);
    SnoAllianceActivityPO getById(Integer id);

    List<Map<String,Object>> listByIds(Integer[] ids);

    Integer getListActivityCount(HashMap<String, Object> paramMap);

    List<Map<String,Object>> listActivity(HashMap<String, Object> paramMap);

    Map<String,Object> getMapById(Integer id);
}
