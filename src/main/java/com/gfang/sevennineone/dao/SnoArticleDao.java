package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoArticlePO;
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
public interface SnoArticleDao {

	SnoArticlePO getById(Integer id);

	Integer save(SnoArticlePO po);

	List<SnoArticlePO> listByMap(Map<String, Object> paramMap);

	Integer getCountByMap(Map<String, Object> paramMap);

	void update(SnoArticlePO po);
}
