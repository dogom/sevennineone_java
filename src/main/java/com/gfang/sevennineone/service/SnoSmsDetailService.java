package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoSmsDetailPO;

/**
 *
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoSmsDetailService {

    SnoSmsDetailPO getById(Integer id);
    Integer save(SnoSmsDetailPO po);
}
