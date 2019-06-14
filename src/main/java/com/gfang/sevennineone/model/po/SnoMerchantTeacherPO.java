package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 机构师资表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoMerchantTeacherPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户id
	private String userId;
	//培训商户id
	private Integer merchatId;
	//教师名称
	private String name;
	//教师类型,如舞蹈教师
	private String category;
	//教师图片
	private String img;
	//头衔
	private String headTitle;
	//教师简介
	private String description;
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
	public void setMerchatId(Integer merchatId) {
		this.merchatId = merchatId;
	}
	/**
	 * 获取：培训商户id
	 */
	public Integer getMerchatId() {
		return merchatId;
	}
	/**
	 * 设置：教师名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：教师名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：教师类型,如舞蹈教师
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：教师类型,如舞蹈教师
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：教师图片
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：教师图片
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：头衔
	 */
	public void setHeadTitle(String headTitle) {
		this.headTitle = headTitle;
	}
	/**
	 * 获取：头衔
	 */
	public String getHeadTitle() {
		return headTitle;
	}
	/**
	 * 设置：教师简介
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：教师简介
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
}
