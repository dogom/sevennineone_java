package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoMerchantImgPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoMerchantImgDao {

	SnoMerchantImgPO getById(Integer id);

	List<SnoMerchantImgPO> listByMerchantId(Integer mid);

	Integer saveBatch(List<SnoMerchantImgPO> poList);
 
}
