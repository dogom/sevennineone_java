package com.gfang.sevennineone.service;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoWechatTradePO;

import java.util.List;
import java.util.Map;

/**
 * 礼物表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoWechatTradeService {

    Integer save(SnoWechatTradePO po);

    SnoWechatTradePO getById(Integer giftId);

    Integer updateTradeSuccess(Map<String, String> wechatNotifyMap);
}
