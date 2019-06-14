package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 小孩表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoChildPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//sno_user主键，家长id
	private String parentId;
	//姓名
	private String name;
	//年龄
	private Integer age;
	//性别，1男2女
	private Integer sex;
	//头像
	private String avatar;
	//创建时间
	private Date createTime;
	//是否删除,0否1是
	private Integer isDelete;

	/**
	 * 设置：id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：sno_user主键，家长id
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：sno_user主键，家长id
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：性别，1男2女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别，1男2女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
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
