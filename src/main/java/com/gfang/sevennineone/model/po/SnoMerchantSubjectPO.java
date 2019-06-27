package com.gfang.sevennineone.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 机构课程表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoMerchantSubjectPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户id
	private String userId;
	//培训商户id
	private Integer merchantId;
	//教师id
	private Integer teacherId;
	//课程名称
	private String name;
	//时长，单位：分钟
	private Integer during;
	//价格
	private Integer price;
	//总节数
	private Integer total;
	//最大学生数
	private Integer maxStudents;
	// 已有学生数
	private Integer realStudents;
	//合适年龄段
	private String suitableAge;
	//广告图片
	private String advImg;
	//1正常状态，2已过期
	private Integer status;
	//频率类型，1每天2每周3每月4每季5每半年6每年7每三年
	private Integer rateType;
	//频率次数，如每周2节
	private Integer rateNum;
	//课程说明
	private String description;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	//是否删除,0否1是
	private Integer isDelete;

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
	 * 设置：培训商户id
	 */
	public void setmerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * 获取：培训商户id
	 */
	public Integer getmerchantId() {
		return merchantId;
	}
	/**
	 * 设置：教师id
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：教师id
	 */
	public Integer getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：课程名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：课程名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：时长，单位：分钟
	 */
	public void setDuring(Integer during) {
		this.during = during;
	}
	/**
	 * 获取：时长，单位：分钟
	 */
	public Integer getDuring() {
		return during;
	}
	/**
	 * 设置：最大学生数
	 */
	public void setMaxStudents(Integer maxStudents) {
		this.maxStudents = maxStudents;
	}
	/**
	 * 获取：最大学生数
	 */
	public Integer getMaxStudents() {
		return maxStudents;
	}
	/**
	 * 设置：合适年龄段
	 */
	public void setSuitableAge(String suitableAge) {
		this.suitableAge = suitableAge;
	}
	/**
	 * 获取：合适年龄段
	 */
	public String getSuitableAge() {
		return suitableAge;
	}
	/**
	 * 设置：广告图片
	 */
	public void setAdvImg(String advImg) {
		this.advImg = advImg;
	}
	/**
	 * 获取：广告图片
	 */
	public String getAdvImg() {
		return advImg;
	}
	/**
	 * 设置：1正常状态，2已过期
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：1正常状态，2已过期
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：频率类型，1每天2每周3每月4每季5每半年6每年7每三年
	 */
	public void setRateType(Integer rateType) {
		this.rateType = rateType;
	}
	/**
	 * 获取：频率类型，1每天2每周3每月4每季5每半年6每年7每三年
	 */
	public Integer getRateType() {
		return rateType;
	}
	/**
	 * 设置：频率次数，如每周2节
	 */
	public void setRateNum(Integer rateNum) {
		this.rateNum = rateNum;
	}
	/**
	 * 获取：频率次数，如每周2节
	 */
	public Integer getRateNum() {
		return rateNum;
	}
	/**
	 * 设置：课程说明
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：课程说明
	 */
	public String getDescription() {
		return description;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRealStudents() {
		return realStudents;
	}

	public void setRealStudents(Integer realStudents) {
		this.realStudents = realStudents;
	}
}
