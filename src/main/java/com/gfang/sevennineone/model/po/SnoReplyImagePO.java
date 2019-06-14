package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/5/27.
 */
public class SnoReplyImagePO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String url; //链接
    private Integer replyId; //报名Id
    private Date createTime; //创建时间
    private Integer isDelete; //是否删除


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
