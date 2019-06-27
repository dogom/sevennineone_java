package com.gfang.sevennineone.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gfang.sevennineone.model.po.SnoReplyPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 报名表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoReplyDao {

	SnoReplyPO getById(Integer id);

	List<Map<String,Object>> getByOpenidAndMerchantId(@Param("openid") String openid,@Param("activityId") Integer activityId,@Param("merchantId") Integer merchantId);

    List<Map<String,Object>> listReplyByMap(Map<String, Object> paramMap);

    Long getReplyCountByMap(Map<String, Object> paramMap);

    Long save(SnoReplyPO snoReplyPO);

    Map<String,Object> getMapById(Integer replyId);

    Integer updatePaidFee(@Param("newAddNum") Integer newAddNum,@Param("replyId") Integer replyId);

    List<Map<String,Object>> listReplyByUser(@Param("openid") String openid,@Param("start") Integer start,@Param("rowCount") Integer rowCount);

    Integer getUserReplyCount(@Param("openid") String openid);

    List<SnoReplyPO> getByIds(Set<Integer> set);

    List<Integer> listAppointmentA(String openid);

    List<Map<String,Object>> listMerchantReply(Map<String,Object> map);
    Integer getMerchantReplyCount(Map<String,Object> map);
    Integer getMerchantTotalMoney(Map<String,Object> map);

    List<Map<String,Object>> listReplyForSearch(Map<String,Object> map);

    void updateProgress(@Param("replyId") Integer replyId,@Param("num") int i);
}
