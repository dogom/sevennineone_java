package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoActivityLinkPO;

import java.util.List;

/**
 *
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoActivityLinkService {

    SnoActivityLinkPO getById(Integer id);

    Integer save(SnoActivityLinkPO po);

    List<SnoActivityLinkPO> listByActivityId(Integer id);

    void update(SnoActivityLinkPO po);

    Integer delete(Integer id);
}
