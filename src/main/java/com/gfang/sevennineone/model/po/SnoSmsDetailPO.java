package com.gfang.sevennineone.model.po;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/10.
 *  短信记录
 */
public class SnoSmsDetailPO {

    private Integer id;
    private String signName;
    private String smsTemplate;
    private String param;
    private Date createTime;

    public SnoSmsDetailPO(String signName, String smsTemplate, String param) {
        this.signName = signName;
        this.smsTemplate = smsTemplate;
        this.param = param;
    }

    public SnoSmsDetailPO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSmsTemplate() {
        return smsTemplate;
    }

    public void setSmsTemplate(String smsTemplate) {
        this.smsTemplate = smsTemplate;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
