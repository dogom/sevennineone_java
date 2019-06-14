package com.gfang.sevennineone.dao;

import java.util.List;
import java.util.Map;
import com.gfang.sevennineone.model.po.SnoMerchantTeacherPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 机构师资表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoMerchantTeacherDao {

	SnoMerchantTeacherPO getById(Integer id);
 
}
