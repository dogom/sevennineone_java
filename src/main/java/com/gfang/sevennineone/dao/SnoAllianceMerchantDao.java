package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoAllianceMerchantPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 活动表
 * Created by Administrator on 2019/5/10.
 */
@Mapper
public interface SnoAllianceMerchantDao {
    SnoAllianceMerchantPO getById(Integer id);

    long save(SnoAllianceMerchantPO po);

    List<SnoAllianceMerchantPO> listByParams(Map<String,Object> map);

    Map<String,Object> getByAidAndMid(@Param("activityId") Integer activityId,@Param("merchantId") Integer merchantId);
}
