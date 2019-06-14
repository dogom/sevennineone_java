package com.gfang.sevennineone.model.po;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoUserPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户id
	@Expose
	private String id;
	//用户昵称
	@Expose
	private String nickname;
	//真名
	private String realname;
	//电话号码
	private String mobile;
	//头像
	@Expose
	private String avatar;
	// 性别
	@Expose
	private String sex;
	// 省
	@Expose
	private String province;
	// 市
	@Expose
	private String city;
	// county
	@Expose
	private String country;
	// 特权
	@Expose
	private String privilege;
	//openid
	private String openid;
	//unionid
	private String unionId;
	// 是否是商家
	@Expose
	private Integer merchant;
	//创建时间
	private Date createTime;
	//是否删除,0否1是
	private Integer isDelete;


	public Integer getMerchant() {
		return merchant;
	}

	public void setMerchant(Integer merchant) {
		this.merchant = merchant;
	}

	/**
	 * 设置：用户id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：用户id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：用户昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：用户昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：真名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：真名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：电话号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：电话号码
	 */
	public String getMobile() {
		return mobile;
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
	 * 设置：openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：unionid
	 */
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	/**
	 * 获取：unionid
	 */
	public String getUnionId() {
		return unionId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}
