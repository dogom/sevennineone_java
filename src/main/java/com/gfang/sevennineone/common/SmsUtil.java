package com.gfang.sevennineone.common;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by Administrator on 2019/6/10.
 */
public class SmsUtil {

    public static Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    public static void sendSms(String phoneNumber,String params,String signName,String templateName) {
        logger.info("发送短信：{},{}",phoneNumber,params);
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIDfBVoVe5AYjt", "W1t4al195hWATTVkjvcxsMSZDs0K8g");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateName);
        request.putQueryParameter("TemplateParam", params);
        try {
            CommonResponse response = client.getCommonResponse(request);
            logger.info(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }



}
