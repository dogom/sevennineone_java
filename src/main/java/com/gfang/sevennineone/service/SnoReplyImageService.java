package com.gfang.sevennineone.service;


import com.gfang.sevennineone.model.po.SnoReplyImagePO;

import java.util.List;
import java.util.Map;

/**
 * 报名表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public interface SnoReplyImageService {
    Long save(SnoReplyImagePO po);
    List<SnoReplyImagePO> listByReplyId(Integer replyId);
    List<SnoReplyImagePO> listByReplyIds(Integer[] replyId);
}
