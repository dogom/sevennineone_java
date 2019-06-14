package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 报名表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoReplyPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户id
	private String openid;
	//小孩姓名
	private String childName;
	//小孩性别
	private Integer childSex;
	//小孩年龄
	private Integer childAge;
	//入学情况，0未入学1幼儿园2小学3初中4高中
	private Integer schoolInfo;
	//课程id
	private Integer subjectId;
	//培训商家id
	private Integer merchantId;
	//联盟活动id
	private Integer activityId;
	//已支付金额
	private Integer paidFee;
	//报名进度，1:0-99，2:99-mid,3:mid-end
	private Integer progress;
	//报名总金额
	private Integer totalFee;
	//创建时间
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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Integer getChildSex() {
		return childSex;
	}

	public void setChildSex(Integer childSex) {
		this.childSex = childSex;
	}

	public Integer getChildAge() {
		return childAge;
	}

	public void setChildAge(Integer childAge) {
		this.childAge = childAge;
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

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * 设置：联盟活动id
	 */
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	/**
	 * 获取：联盟活动id
	 */
	public Integer getActivityId() {
		return activityId;
	}
	/**
	 * 设置：已支付金额
	 */
	public void setPaidFee(Integer paidFee) {
		this.paidFee = paidFee;
	}
	/**
	 * 获取：已支付金额
	 */
	public Integer getPaidFee() {
		return paidFee;
	}
	/**
	 * 设置：报名进度，1:0-99，2:99-mid,3:mid-end
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	/**
	 * 获取：报名进度，1:0-99，2:99-mid,3:mid-end
	 */
	public Integer getProgress() {
		return progress;
	}
	/**
	 * 设置：报名总金额
	 */
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * 获取：报名总金额
	 */
	public Integer getTotalFee() {
		return totalFee;
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
}
