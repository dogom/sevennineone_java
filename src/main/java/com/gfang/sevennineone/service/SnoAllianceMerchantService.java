package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoAllianceMerchantPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 联盟活动表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoAllianceMerchantService {

    Integer save(SnoAllianceMerchantPO po);
    SnoAllianceMerchantPO getById(Integer id);
    List<SnoAllianceMerchantPO> listByParams(Map<String,Object> map);

    Map<String,Object> getByAidAndMid(Integer aid, Integer mid);

    Map<String,Object> getExistsByAidAndMid(Integer aid, Integer mid);


    void updateAfterAudit(Integer merchantId);

    void updateReplyCount(Integer activityId, Integer merchantId);

    List<Map<String,Object>> listMerchantForSearch(Map<String,Object> map);
}
