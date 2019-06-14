package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoChildPO;
import com.gfang.sevennineone.model.po.SnoSmsDetailPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 小孩表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoSmsDetailDao {

	SnoSmsDetailPO getById(Integer id);

	Integer save(SnoSmsDetailPO po);

}
