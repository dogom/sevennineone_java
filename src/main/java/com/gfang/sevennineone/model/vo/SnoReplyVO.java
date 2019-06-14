package com.gfang.sevennineone.model.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/27.
 */
public class SnoReplyVO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String childName;
    private Integer childAge;
    private Integer childSex;
    private Integer schoolInfo;
    private Integer subjectId;
    private Integer activityId;
    private Integer merchantId;
    private String lifePhoto;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Integer getChildAge() {
        return childAge;
    }

    public void setChildAge(Integer childAge) {
        this.childAge = childAge;
    }

    public Integer getChildSex() {
        return childSex;
    }

    public void setChildSex(Integer childSex) {
        this.childSex = childSex;
    }

    public Integer getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(Integer schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getLifePhoto() {
        return lifePhoto;
    }

    public void setLifePhoto(String lifePhoto) {
        this.lifePhoto = lifePhoto;
    }
}
