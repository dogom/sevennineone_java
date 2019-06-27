package com.gfang.sevennineone.service;


import com.gfang.sevennineone.model.po.SnoReplyPO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 报名表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoReplyService {

    List<Map<String,Object>> getByOpenidAndMerchantId(String openid,Integer activityId, Integer merchantId);

    List<Map<String,Object>> listReplyByMap(Map<String, Object> paramMap);

    Long getReplyCountByMap(Map<String, Object> paramMap);

    Long save(SnoReplyPO snoReplyPO);

    Map<String,Object> getMapById(Integer replyId);

    Integer updatePaidFee(Integer newAddNum,Integer replyId);

    List<Map<String,Object>> listReplyByUser(String openid,Integer start,Integer rowCount);

    Integer getUserReplyCount(String openid);

    List<SnoReplyPO> getByIds(Set<Integer> set);

    List<Integer> listAppointmentA(String openid);

    List<Map<String,Object>> listMerchantReply(Map<String,Object> map);
    Integer getMerchantReplyCount(Map<String,Object> map);
    Integer getMerchantTotalMoney(Map<String,Object> map);

    List<Map<String,Object>> listReplyForSearch(Map<String,Object> map);

    void updateProgress(Integer replyId, int i);
}
