package com.gfang.sevennineone.service;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoHomeCategoryPO;

import java.util.List;

/**
 * 礼物表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoHomeCategoryService {

    ApiResultVO add(SnoHomeCategoryPO po);

    List<SnoHomeCategoryPO> listHomeCategory();
}
