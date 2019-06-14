package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoReplyDonationPO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报名助学表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoReplyDonationService {

    List<Map<String,Object>> listMapByReplyId(Map<String,Object> map);

    Integer save(SnoReplyDonationPO po);

    Integer getCountByReplyId(HashMap<String, Object> paramMap);

    Integer updateDonateSuccess(Map<String, String> wechatNotifyMap);

    SnoReplyDonationPO getByOutTradeNo(String out_trade_no);

    List<Map<String,Object>> listDonationByUser(Map<String, Object> paramMap);

    Integer getCountByUser(Map<String, Object> paramMap);
}
