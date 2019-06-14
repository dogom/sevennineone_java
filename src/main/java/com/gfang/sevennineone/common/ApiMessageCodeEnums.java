package com.gfang.sevennineone.common;

/**
 * Created by Administrator on 2019/5/5.
 */
public enum  ApiMessageCodeEnums {

    NO_ERROR(0, "操作成功"),
    ERROR_SYSTEM(-1001, "您的网络服务繁忙，请稍后重试!"),
    ERROR_EMPTY_PARAM(-1002, "您输入的信息不完整，请检查后重新提交"),
    BUSSINESS_EXCEPTOIN(-1003, "业务异常"),
    ERROR_ACCOUNT_FREEZE(-1004, "账户冻结"),
    INVALID_LOGIN(-1005, "非法登陆"),
    NO_LOGIN(-1006,"用户未登陆"),
    ERROR_USER(-1007,"用户参数错误"),
    TOKEN_EXPIRED(-1008,""),//用户登陆token失效
    TOKEN_ERROR(-1009,"用户登陆token错误"),
    MOBILE_ERROR(-1011, "手机号错误"),
    SMS_CODE_ERROR(-1012, "您的验证码错误"),
    MOBILE_EXISTENCE(-1013, "手机号存在"),
    MOBILE_OR_CODE_ERROR(-1014,"您输入账号或密码有误"),

    INVALID_REQUEST(-1015, "拦截器未找到用户userId或token"),
    WX_INVALID_REQUEST(-1016, "微信拦截器未找到用户userId"),
    DUPLICATE_APPLY_ERROR(-1014, "重复申请同一个银行的信用卡"),
    ROLE_ERROR(-1018, "您还没有该权限，请开通后再使用"),
    ROLE_ERROR_FOR_TARGET_WORKER(-1019, "预约对象无工人权限"),
    CUST_EXISTERROR(-1020, "已经是商户，无法入驻"),
    FILE_FORMAT_ERROR(-6001, "上传文件格式错误"),
    FILE_SIZE_ERROR(-6002, "上传文件大小不能大于2M"),
    ILLEGALCHAR(-7001,"包含非法字符"),;

    private int code;

    private String message;

    private ApiMessageCodeEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
