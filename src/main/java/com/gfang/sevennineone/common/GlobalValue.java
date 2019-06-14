package com.gfang.sevennineone.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2019/5/5.
 */
@Component
public class GlobalValue {

    @PostConstruct
    public void init() {
        OSS_ALIYUNURL = ossAliyunUrlTmp;
        OSS_ENDPOINT =ossEndPointTmp;
        OSS_ACCESSKEYID =ossAccessKeyIdTmp;
        OSS_ACCESSKEYSECRET =ossAccessKeySecretTmp;
        OSS_BUCKETNAME =ossBucketNameTmp;
        APP_ID =appId;
        APP_SECRET =appSecret;
        MCH_ID = mchId;
        KEY = keyTmp;
    }
    // oss
    @Value("${oss_aliyunUrl}")
    public  String ossAliyunUrlTmp;
    @Value("${oss_endpoint}")
    public  String ossEndPointTmp;
    @Value("${oss_accessKeyId}")
    public  String ossAccessKeyIdTmp;
    @Value("${oss_accessKeySecret}")
    public  String ossAccessKeySecretTmp;
    @Value("${oss_bucketName}")
    public  String ossBucketNameTmp;
    // 微信
    @Value("${app_id}")
    public  String appId;
    @Value("${app_secret}")
    public  String appSecret;
    @Value("${mch_id}")
    public String mchId;
    @Value("${key}")
    public String keyTmp;


    //阿里云OSS配置
    public static String OSS_ALIYUNURL;
    public static String OSS_ENDPOINT;
    public static String OSS_ACCESSKEYID;
    public static String OSS_ACCESSKEYSECRET;
    public static String OSS_BUCKETNAME;
    public static String APP_ID;
    public static String APP_SECRET;
    public static String MCH_ID;
    public static String KEY;

}
