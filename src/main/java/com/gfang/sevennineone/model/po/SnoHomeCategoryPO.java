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
public class SnoHomeCategoryPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//分类名称
	private String name;
	//图片地址
	private String url;
	//排序，越大越靠前
	private Integer sort;
	//创建时间
	private Date createTime;
	//是否删除,0否1是
	private Integer isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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
