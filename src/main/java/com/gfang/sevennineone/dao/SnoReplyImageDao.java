package com.gfang.sevennineone.dao;

import com.gfang.sevennineone.model.po.SnoReplyImagePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27.
 */
@Mapper
public interface SnoReplyImageDao {

    Long save(SnoReplyImagePO po);

    List<SnoReplyImagePO> listByReplyId(Integer replyId);

    List<SnoReplyImagePO> listByReplyIds(Integer[] replyIds);
}
