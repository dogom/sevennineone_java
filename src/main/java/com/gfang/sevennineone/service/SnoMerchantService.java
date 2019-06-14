package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoMerchantPO;

import java.util.List;
import java.util.Map;

/**
 * 机构表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoMerchantService {
    List<Map<String,Object>> listMerchant(Map<String,Object> map);

    SnoMerchantPO getById(Integer id);
    Map<String,Object> getMerchantById(Integer id);

    List<Map<String,Object>> listByIds(Integer[] integers);

    void updateReplyCountAddOne(Integer merchantId);

    Integer save(SnoMerchantPO po);

    SnoMerchantPO getByUserId(String userId);

    Integer update(SnoMerchantPO po);

    Integer updateAuditStatus(Integer merchantId,Integer fromStatus,Integer toStatus);
}
