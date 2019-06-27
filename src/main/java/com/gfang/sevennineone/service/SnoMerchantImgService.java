package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoMerchantImgPO;

import java.util.List;

/**
 *
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoMerchantImgService {

    SnoMerchantImgPO getById(Integer id);

    List<SnoMerchantImgPO> listByMerchantId(Integer mid);

    Integer saveBatch(List<SnoMerchantImgPO> poList);

}
