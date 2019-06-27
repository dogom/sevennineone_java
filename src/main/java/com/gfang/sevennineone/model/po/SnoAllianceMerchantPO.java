package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动成员表
 * Created by Administrator on 2019/5/10.
 */
public class SnoAllianceMerchantPO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // id
    private Integer merchantId; //商家id
    private Integer activityId; //活动id
    private Integer status; //状态，0审核中1审核通过2审核拒绝
    private String auditFailMsg; //审核失败留言
    private Date auditTime; //审核通过时间
    private Integer experienceNum; //联盟卡体验次数
    private Integer replyCount; // 报名人数
    private Date createTime; //创建时间
    private Integer isDelete; //是否删除


    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getId() {
        return id;
    }

    public String getAuditFailMsg() {
        return auditFailMsg;
    }

    public void setAuditFailMsg(String auditFailMsg) {
        this.auditFailMsg = auditFailMsg;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExperienceNum() {
        return experienceNum;
    }

    public void setExperienceNum(Integer experienceNum) {
        this.experienceNum = experienceNum;
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
