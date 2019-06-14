package com.gfang.sevennineone.common;

import com.alibaba.druid.util.StringUtils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.alibaba.druid.util.Utils.md5;

/**
 * Created by Administrator on 2019/5/5.
 */
public class OSSUtil {

    private static Logger logger = LoggerFactory.getLogger(OSSUtil.class);

    public static OSSClient getOssClient(){
        return OSSClientSingleton.ossClient;
    }

    private static class OSSClientSingleton {
        private static final OSSClient ossClient =  new OSSClient(GlobalValue.OSS_ENDPOINT ,GlobalValue.OSS_ACCESSKEYID,GlobalValue.OSS_ACCESSKEYSECRET);
    }

    public static ApiResultVO upload(String path, MultipartFile multipartFile){
        ApiResultVO apiResultVO = new ApiResultVO();
        /** 图片上传 */
        String url = null,
                originalFilename = stringFilter(multipartFile.getOriginalFilename()),
                prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        StringBuilder fileNameStr = new StringBuilder();
        path = StringUtils.isEmpty(path) ? "default" : path;
        fileNameStr.append(path)
                .append("/")
                .append(md5(originalFilename+System.currentTimeMillis()))
                .append("."+prefix);
        try {
            uploadFileStream(multipartFile.getInputStream(), fileNameStr.toString());
            url = "https://"+GlobalValue.OSS_BUCKETNAME+"."+GlobalValue.OSS_ENDPOINT+"/"+fileNameStr.toString();
        } catch (IOException e) {
            apiResultVO.setCode(500);
            apiResultVO.setMessage("图片上传失败");
            logger.error("上传图片出错");
        }
        apiResultVO.setData(url);

        return apiResultVO;
    }

    public static String uploadFile(String path,InputStream fileInput){
        String url = null;
        StringBuilder fileNameStr = new StringBuilder();
        path = StringUtils.isEmpty(path) ? "default" : path;
        String prefix = "png";
        fileNameStr.append(path)
                .append("/")
                .append(md5(String.valueOf(System.currentTimeMillis())))
                .append("."+prefix);
        try {
            uploadFileStream(fileInput, fileNameStr.toString());
            url = "https://"+GlobalValue.OSS_BUCKETNAME+"."+GlobalValue.OSS_ENDPOINT+"/"+fileNameStr.toString();
        } catch (Exception e) {

        }
        return url;
    }

    //上传文件流
    private static PutObjectResult uploadFileStream(InputStream is, String fileName){
        return getOssClient().putObject(GlobalValue.OSS_BUCKETNAME, fileName, is);
    }

    private static String stringFilter(String code) {
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(code);
        return m.replaceAll("").trim();
    }

}
