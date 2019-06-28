package com.gfang.sevennineone.model.po;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/27.
 */
public class SnoActivityLinkPO {

    private Integer id; //id
    private String img; //显示图片
    private Integer activityId; //活动id
    private String link; //链接到的内容
    private Integer isShow; //是否显示
    private Date createTime; //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
