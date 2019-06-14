package com.gfang.sevennineone.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gfang.sevennineone.model.po.SnoReplyDonationPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 报名助学表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoReplyDonationDao {

	SnoReplyDonationPO getById(Integer id);

	Integer save(SnoReplyDonationPO donationPO);

	List<Map<String,Object>> listMapByReplyId(Map<String,Object> map);

    Integer getCountByReplyId(HashMap<String, Object> paramMap);

    Integer updateDonateSuccess(Map<String, String> wechatNotifyMap);

	SnoReplyDonationPO getByOutTradeNo(String outTradeNo);

    List<Map<String,Object>> listDonationByUser(Map<String, Object> map);

	Integer getCountByUser(Map<String, Object> map);
}
