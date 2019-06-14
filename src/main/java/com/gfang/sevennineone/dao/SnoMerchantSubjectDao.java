package com.gfang.sevennineone.dao;

import java.util.List;
import java.util.Map;
import com.gfang.sevennineone.model.po.SnoMerchantSubjectPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 机构课程表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoMerchantSubjectDao{

	SnoMerchantSubjectPO getById(Integer id);
	 List<Map<String,Object>> listSubject(Integer merchantId);

    void updateRealStudentAddOne(Integer subjectId);

    Integer saveBatch(List<SnoMerchantSubjectPO> subjectPOList);

    List<Map<String,Object>> listByUserId(String id);

    void deleteBatchByMerchantId(Integer merchantId);

    Integer save(SnoMerchantSubjectPO po);

    Integer update(SnoMerchantSubjectPO po);

    List<SnoMerchantSubjectPO> listByMerchantIds(Integer[] merchantIds);
}
