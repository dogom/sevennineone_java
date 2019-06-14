package com.gfang.sevennineone.dao;

import java.util.List;
import java.util.Map;
import com.gfang.sevennineone.model.po.SnoGiftPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 礼物表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoGiftDao {

	SnoGiftPO getById(Integer id);
 	long save(SnoGiftPO po);

    List<Map<String,Object>> listMapGift();


}
