package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 机构表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoMerchantPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户id
	private String userId;
	//机构名称
	private String name;
	//一句话宣传语
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


	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "SnoMerchantPO{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", bmapLoca='" + bmapLoca + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", area='" + area + '\'' +
				", address='" + address + '\'' +
				", logo='" + logo + '\'' +
				", banner='" + banner + '\'' +
				", hotNum=" + hotNum +
				", replyCount=" + replyCount +
				", isTop=" + isTop +
				", categoryId=" + categoryId +
				", categoryName='" + categoryName + '\'' +
				", tel='" + tel + '\'' +
				", vipLevel=" + vipLevel +
				", idCardFront='" + idCardFront + '\'' +
				", idCardBack='" + idCardBack + '\'' +
				", businessLicense='" + businessLicense + '\'' +
				", auditStatus=" + auditStatus +
				", auditFailMsg='" + auditFailMsg + '\'' +
				", createTime=" + createTime +
				", isDeposit=" + isDeposit +
				", depositFee=" + depositFee +
				", isDelete=" + isDelete +
				'}';
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：机构名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：机构名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：机构简介
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：机构简介
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：百度地图坐标
	 */
	public void setBmapLoca(String bmapLoca) {
		this.bmapLoca = bmapLoca;
	}
	/**
	 * 获取：百度地图坐标
	 */
	public String getBmapLoca() {
		return bmapLoca;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：联系电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：vip等级
	 */
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}
	/**
	 * 获取：vip等级
	 */
	public Integer getVipLevel() {
		return vipLevel;
	}
	/**
	 * 设置：身份证人像面
	 */
	public void setIdCardFront(String idCardFront) {
		this.idCardFront = idCardFront;
	}
	/**
	 * 获取：身份证人像面
	 */
	public String getIdCardFront() {
		return idCardFront;
	}
	/**
	 * 设置：身份证国徽面
	 */
	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}
	/**
	 * 获取：身份证国徽面
	 */
	public String getIdCardBack() {
		return idCardBack;
	}
	/**
	 * 设置：营业执照
	 */
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	/**
	 * 获取：营业执照
	 */
	public String getBusinessLicense() {
		return businessLicense;
	}
	/**
	 * 设置：审核状态，1待审核，2审核通过，3审核未通过
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态，1待审核，2审核通过，3审核未通过
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：审核未通过留言
	 */
	public void setAuditFailMsg(String auditFailMsg) {
		this.auditFailMsg = auditFailMsg;
	}
	/**
	 * 获取：审核未通过留言
	 */
	public String getAuditFailMsg() {
		return auditFailMsg;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：是否交押金,0否1是
	 */
	public void setIsDeposit(Integer isDeposit) {
		this.isDeposit = isDeposit;
	}
	/**
	 * 获取：是否交押金,0否1是
	 */
	public Integer getIsDeposit() {
		return isDeposit;
	}
	/**
	 * 设置：押金金额，单位：分
	 */
	public void setDepositFee(Integer depositFee) {
		this.depositFee = depositFee;
	}
	/**
	 * 获取：押金金额，单位：分
	 */
	public Integer getDepositFee() {
		return depositFee;
	}
	/**
	 * 设置：是否删除,0否1是
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除,0否1是
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	public Integer getHotNum() {
		return hotNum;
	}

	public void setHotNum(Integer hotNum) {
		this.hotNum = hotNum;
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
}
