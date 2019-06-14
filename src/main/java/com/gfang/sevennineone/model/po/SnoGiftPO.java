package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 礼物表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoGiftPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//礼物名称
	private String name;
	//礼物图片
	private String img;
	//礼物价值,单位:分，如10表示1个礼物1毛钱
	private Integer worth;
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
	 * 设置：礼物名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：礼物名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：礼物图片
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：礼物图片
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：礼物价值,单位:分，如10表示1个礼物1毛钱
	 */
	public void setWorth(Integer worth) {
		this.worth = worth;
	}
	/**
	 * 获取：礼物价值,单位:分，如10表示1个礼物1毛钱
	 */
	public Integer getWorth() {
		return worth;
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
