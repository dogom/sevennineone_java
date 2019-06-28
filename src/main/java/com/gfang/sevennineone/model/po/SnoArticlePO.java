package com.gfang.sevennineone.model.po;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/27.
 *  文章
 */
public class SnoArticlePO {

    private Integer id; //id
    private String userId; //userid
    private String title; //标题
    private String pageText; //内容
    private Integer isShow; //是否显示，0显示1否
    private Date createTime; //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageText() {
        return pageText;
    }

    public void setPageText(String pageText) {
        this.pageText = pageText;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
