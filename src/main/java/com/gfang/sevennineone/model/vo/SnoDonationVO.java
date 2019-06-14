package com.gfang.sevennineone.model.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/30.
 */
public class SnoDonationVO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer giftId;
    private Integer replyId;
    private Integer giftNum;

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }
}
