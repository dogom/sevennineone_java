package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoActivityLinkPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoActivityLinkDao {

	SnoActivityLinkPO getById(Integer id);

	Integer save(SnoActivityLinkPO po);

    List<SnoActivityLinkPO> listByActivityId(Integer id);

	void update(SnoActivityLinkPO po);

	Integer delete(Integer id);
}
