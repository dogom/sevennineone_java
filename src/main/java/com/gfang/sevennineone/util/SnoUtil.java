package com.gfang.sevennineone.util;

import com.gfang.sevennineone.cache.LocalCache;
import com.gfang.sevennineone.common.GlobalValue;
import com.gfang.sevennineone.common.OSSUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2019/5/31.
 */
public class SnoUtil {

    private static Logger logger = LoggerFactory.getLogger(SnoUtil.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 获取指定长度随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

    //将字节数组转化为字符串
    public static String convertbyte2String(byte[] byteResult)
    {
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };

        //4位代表一个16进制，所以长度需要变为原来2倍
        char[] result = new char[byteResult.length*2];

        int index = 0;
        for(byte b:byteResult)
        {
            //先转换高4位
            result[index++] = hexDigits[(b>>>4)& 0xf];
            result[index++] = hexDigits[b& 0xf];
        }
        return new String(result);
    }

    // 生成订单号
    public static String getUniqueOrderId(){
        String dateStr = dateFormat.format(new Date());
        return "sno"+dateStr+getRandomString(8);
    }

    /**
     * 生成签名
     * @param parameters
     * @return sign
     */
    public static String createSign(SortedMap<Object, Object> parameters){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + GlobalValue.KEY);
        String sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
        return sign;
    }

    /**
     * @author
     * @date 2016-4-22
     * @Description：将请求参数转换为xml格式的string
     * @param parameters
     *            请求参数
     * @return
     */
    public static String getRequestXml(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            //if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
            sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            // } else {
            //  sb.append("<" + k + ">" + v + "</" + k + ">");
            //}
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            throw ex;
        }

    }

    /** 微信accesstoken获取
     *  res {"access_token":"ACCESS_TOKEN","expires_in":7200}
     */
    public static String getAccessToken() throws IOException {
        String accessToken = null;
        if (LocalCache.containsKey("accessToken")) {
            Map<String, String> map = (Map<String, String>) LocalCache.get("accessToken");
            accessToken = map.get("access_token");
        } else {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
            String res = httpGetMethod(url.replace("APPID", GlobalValue.APP_ID).replace("APPSECRET", GlobalValue.APP_SECRET));
            Map<String, String> tokenMap = new Gson().fromJson(res, HashMap.class);
            logger.info("获取微信access_token接口返回：{}", tokenMap);
            accessToken = tokenMap.get("access_token");
            LocalCache.put("accessToken", tokenMap,7200);
        }
        return accessToken;
    }

    /** 微信服务器图片下载 */
    public static String downloadWxImage(String serverId) throws IOException {
        String accessToken = getAccessToken();
        logger.info("accessToken:{}",accessToken);
        String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=" + accessToken + "&media_id=" + serverId;
        return OSSUtil.uploadFile("logo", new URL(url).openStream());
    }


    /** http 请求get方法 */
    public static String httpGetMethod(String url) throws IOException{
        StringBuilder sb = new StringBuilder();

        URL accessTokenUrl = new URL(url);
        URLConnection urlConnection = accessTokenUrl.openConnection();
        String line = null;
        try (
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr)
        ) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            // ignore
        }

        return sb.toString();
    }


    /** http 请求Post方法 */
    public static String httpPOstMethod(String postUrl,String postData) throws IOException {
        String response = null;

        int    postDataLength = postData.length();
        URL    url            = new URL( postUrl );
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        conn.setRequestMethod( "POST" );
//        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        conn.setUseCaches( false );
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData.getBytes());
        }
        try(Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))){
            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0;)
                sb.append((char)c);
            response = sb.toString();
        }

        return response;
    }

}
