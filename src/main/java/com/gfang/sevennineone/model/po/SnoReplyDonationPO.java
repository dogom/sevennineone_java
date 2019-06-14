package com.gfang.sevennineone.model.po;

import java.io.Serializable;
import java.util.Date;



/**
 * 报名助学表
 * 
 * @author xs
 * @email 314348789@qq.com
 * @date 2019-05-05 14:59
 */
public class SnoReplyDonationPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//报名id
	private Integer replyId;
	//助学人id
	private String userId;
	//助学人名称
	private String nickname;
	//助学人头像
	private String avatar;
	//礼物id
	private Integer giftId;
	//礼物名称
	private String giftName;
	//礼物数量
	private Integer giftNum;
	//礼物图片
	private String giftImg;
	//礼物折算费用
	private Integer totalFee;
	//支付标记，0未支付1支付成功
	private Integer payStatus;
	//订单号
	private String outTradeNo;
	//创建时间
	private Date createTime;
	//是否删除,0否1是
	private Integer isDelete;

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
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
	 * 设置：报名id
	 */
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	/**
	 * 获取：报名id
	 */
	public Integer getReplyId() {
		return replyId;
	}
	/**
	 * 设置：助学人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：助学人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：助学人名称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：助学人名称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：助学人头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：助学人头像
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：礼物id
	 */
	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
	/**
	 * 获取：礼物id
	 */
	public Integer getGiftId() {
		return giftId;
	}
	/**
	 * 设置：礼物名称
	 */
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	/**
	 * 获取：礼物名称
	 */
	public String getGiftName() {
		return giftName;
	}

	public Integer getGiftNum() {
		return giftNum;
	}

	public void setGiftNum(Integer giftNum) {
		this.giftNum = giftNum;
	}

	public String getGiftImg() {
		return giftImg;
	}

	public void setGiftImg(String giftImg) {
		this.giftImg = giftImg;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
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
