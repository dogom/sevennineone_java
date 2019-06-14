package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoAppointmentPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 预约表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoAppointmentDao {

	SnoAppointmentPO getById(Integer id);
 	Integer save(SnoAppointmentPO po);

 	List<SnoAppointmentPO> listByUserId(String userId);


	List<SnoAppointmentPO> listByMerchantId(Integer merchantId);

	Integer updateStatus(@Param("fromStatus") Integer fromStatus,@Param("toStatus") Integer toStatus, @Param("id") Integer id);
}
