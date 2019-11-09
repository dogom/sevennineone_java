package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoActivityPrizePO;
import com.gfang.sevennineone.model.po.SnoChildPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoActivityPrizeDao {

	SnoChildPO getById(Integer id);

	Integer save(SnoActivityPrizePO po);

	Integer update(SnoActivityPrizePO po);
	List<SnoActivityPrizePO> listByMap(Map<String,Object> map);
	Integer getCountByMap(Map<String,Object> map);

}
