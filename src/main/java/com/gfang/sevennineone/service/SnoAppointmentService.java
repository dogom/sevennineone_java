package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoAppointmentPO;

import java.util.List;
import java.util.Map;

/**
 *
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoAppointmentService {

    SnoAppointmentPO getById(Integer id);
    Integer save(SnoAppointmentPO po);
    List<SnoAppointmentPO> listByUserId(String userId);

    List<SnoAppointmentPO> listByMerchantId(Integer id);

    Integer updateStatus(Integer fromStatus, Integer toStatus, Integer id);
}
