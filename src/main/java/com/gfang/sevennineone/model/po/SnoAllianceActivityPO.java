package com.gfang.sevennineone.model.po;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/5/10.
 */
public class SnoAllianceActivityPO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; //id
    private String userId; // userId
    private String name; //活动名称
    private String logo; //活动logo
    private String poster; //活动标语
    private String description; //活动介绍
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate; //活动开始时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate; //活动结束时间
    private String province; //省
    private String city; //市
    private String area; //区县
    private Integer placeLevel; //地区等级 ，1省2市3区
    private Integer status; //0审核中，1正常状态，2已过期
    private Integer auditStatus; //审核状态，1待审核2审核通过3审核不通过
    private String auditFailMsg; //审核不通过留言
    private Date createTime; //创建时间
    private Integer isDelete; //是否删除

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getPlaceLevel() {
        return placeLevel;
    }

    public void setPlaceLevel(Integer placeLevel) {
        this.placeLevel = placeLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditFailMsg() {
        return auditFailMsg;
    }

    public void setAuditFailMsg(String auditFailMsg) {
        this.auditFailMsg = auditFailMsg;
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
