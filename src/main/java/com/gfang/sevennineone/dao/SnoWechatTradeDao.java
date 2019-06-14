package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoWechatTradePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 礼物表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoWechatTradeDao {

	SnoWechatTradePO getById(Integer id);
 	Integer save(SnoWechatTradePO po);


	Integer updateTradeSuccess(Map<String, String> wechatNotifyMap);
}
