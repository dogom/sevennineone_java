package com.gfang.sevennineone.service;

import com.gfang.sevennineone.model.po.SnoArticlePO;

import java.util.List;
import java.util.Map;

/**
 *
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoArticleService {

    SnoArticlePO getById(Integer id);

    Integer save(SnoArticlePO po);

    List<SnoArticlePO> listByMap(Map<String, Object> paramMap);

    Integer getCountByMap(Map<String, Object> paramMap);

    void update(SnoArticlePO po);
}
