package com.gfang.sevennineone.model.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/6/14.
 */
public class SnoMerchantVO {


    //id
    private Integer id;
    //用户id
    private String userId;
    //机构名称
    private String name;
    private String poster;
    //机构简介
    private String description;
    //百度地图坐标
    private String bmapLoca;
    //省
    private String province;
    private String city;
    private String area;
    //地址
    private String address;
    //logo
    private String logo;
    //banner
    private String banner;
    //热度
    private Integer hotNum;
    //报名人数
    private Integer replyCount;
    //是否置顶
    private Integer isTop;
    //分类id
    private Integer categoryId;
    //分类名称
    private String categoryName;
    //联系电话
    private String tel;
    //vip等级
    private Integer vipLevel;
    //身份证人像面
    private String idCardFront;
    //身份证国徽面
    private String idCardBack;
    //营业执照
    private String businessLicense;
    //审核状态，1待审核，2审核通过，3审核未通过
    private Integer auditStatus;
    //审核未通过留言
    private String auditFailMsg;
    //创建时间
    private Date createTime;
    //是否交押金,0否1是
    private Integer isDeposit;
    //押金金额，单位：分
    private Integer depositFee;
    //是否删除,0否1是
    private Integer isDelete;
    // 图片列表
    private List<String> merchantImgList;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBmapLoca() {
        return bmapLoca;
    }

    public void setBmapLoca(String bmapLoca) {
        this.bmapLoca = bmapLoca;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    public String getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
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

    public Integer getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(Integer isDeposit) {
        this.isDeposit = isDeposit;
    }

    public Integer getDepositFee() {
        return depositFee;
    }

    public void setDepositFee(Integer depositFee) {
        this.depositFee = depositFee;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<String> getMerchantImgList() {
        return merchantImgList;
    }

    public void setMerchantImgList(List<String> merchantImgList) {
        this.merchantImgList = merchantImgList;
    }
}
