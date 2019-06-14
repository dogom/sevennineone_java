package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoHomeCategoryPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 礼物表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoHomeCategoryDao {

	SnoHomeCategoryPO getById(Integer id);
 	long save(SnoHomeCategoryPO po);
 	List<SnoHomeCategoryPO> listHomeCategory();

}
