package com.gfang.sevennineone.dao;

import java.util.List;
import java.util.Map;
import com.gfang.sevennineone.model.po.SnoMerchantPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 机构表
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
@Mapper
public interface SnoMerchantDao{

	SnoMerchantPO getById(Integer id);

	Map<String,Object> getMerchantById(Integer id);

	List<Map<String,Object>> listMerchant(Map<String,Object> map);
    Integer getMerchantCountByMap(Map<String,Object> map);

    List<Map<String,Object>> listByIds(Integer[] ids);

    void updateReplyCountAddOne(Integer merchantId);

    Integer save(SnoMerchantPO po);

    SnoMerchantPO getByUserId(String userId);

    Integer update(SnoMerchantPO po);

    Integer updateAuditStatus(@Param("merchantId") Integer merchantId,@Param("fromStatus") Integer fromStatus,@Param("auditFailMsg") String auditFailMsg,@Param("toStatus") Integer toStatus);

    Integer updateAddressInfo(@Param("id") Integer id,@Param("address") String address,@Param("bmapLoca") String bmapLoca);

    void updateHotNum(@Param("merchantId") Integer merchantId,@Param("num") int num);

}
