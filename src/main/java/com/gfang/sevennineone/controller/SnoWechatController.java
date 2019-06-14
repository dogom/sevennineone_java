package com.gfang.sevennineone.controller;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.cache.LocalCache;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.common.GlobalValue;
import com.gfang.sevennineone.common.OSSUtil;
import com.gfang.sevennineone.model.po.SnoGiftPO;
import com.gfang.sevennineone.model.po.SnoReplyDonationPO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.model.po.SnoWechatTradePO;
import com.gfang.sevennineone.model.vo.SnoDonationVO;
import com.gfang.sevennineone.service.*;
import com.gfang.sevennineone.util.SnoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 微信接口
 * Created by Administrator on 2019/5/13.
 */
@RestController
@RequestMapping("wechat")
public class SnoWechatController {

    private Logger logger = LoggerFactory.getLogger(SnoWechatController.class);

    @Autowired
    private SnoUserService snoUserService;
    @Autowired
    private SnoGiftService snoGiftService;
    @Autowired
    private SnoReplyService snoReplyService;
    @Autowired
    private SnoWechatTradeService snoWechatTradeService;
    @Autowired
    private SnoReplyDonationService snoReplyDonationService;


    /**
     * 微信js授权
     *  accessTokenMap: {
     *    "access_token": "21_-IDDLo_HnDM2btvePmzXvWotY3sqbL-TmtYeF3qzUtZZvVF0bJUzcqAGI1qw89IaTAla5xVMvQeFoR8LsLyUhA",
     *    "expires_in": 7200,
     *    "refresh_token": "21_qXxK7b7nuXeT3LlFU2tb8OJ5oIoizs1RlGozTG_rAys_oKqtNJ9zYj1VL4dO00Kdw6kC550rDYEasRrZTYR2qA",
     *    "openid": "oO5nq1WAm_X8dJpVhZakgDrnEDz0",
     *    "scope": "snsapi_base"
     *    }
     */
    @GetMapping("accessToken")
    public ApiResultVO authorize(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletResponse response) throws IOException {
        logger.debug("微信access_token回调，code：{}，state:{}", code, state);
        ApiResultVO apiResultVO = new ApiResultVO();
        Map<String, Object> resultMap = new HashMap<>(); // 返回结果

        /** 1,请求access_token */
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=APPID" +
                "&secret=SECRET" +
                "&code=CODE" +
                "&grant_type=authorization_code";
        String acctoken_response = null;
        try {
            acctoken_response = SnoUtil.httpGetMethod(url.replace("APPID", GlobalValue.APP_ID).replace("SECRET", GlobalValue.APP_SECRET).replace("CODE", code));
        } catch (IOException e) {
            logger.error("请求微信授权接口异常：{}",e.getMessage());
            e.printStackTrace();
        }
        Map<String,String> accessTokenMap = new Gson().fromJson(acctoken_response, HashMap.class); // 微信返回数据
        logger.info("accesstokenmap: {}",accessTokenMap);

        /** 2. 用户openid去查询用户信息 静默只查询openid,返回前端 */
        String openid = accessTokenMap.get("openid");
        if(Objects.equals(accessTokenMap.get("scope"), "snsapi_userinfo")){
            String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                    "access_token=ACCESS_TOKEN" +
                    "&openid=OPENID" +
                    "&lang=zh_CN";
            String userinfo = SnoUtil.httpGetMethod(userInfoUrl.replace("ACCESS_TOKEN", accessTokenMap.get("access_token")).replace("OPENID", accessTokenMap.get("openid")));
            logger.info("userinfo: {}", userinfo);
            Map<String, String> userinfoMap = new Gson().fromJson(userinfo, HashMap.class); // userinfo
            logger.info("userinfoMap: {}", userinfoMap);
            SnoUserPO user = snoUserService.getByOpenId(openid);
            if(user == null){
                snoUserService.saveByMap(userinfoMap);
                user = snoUserService.getByOpenId(openid);
            }else{
                // 更新，先看用户信息是否变动
                if(user.getAvatar().equals(userinfoMap.get("headimgurl"))
                        && user.getNickname().equals(userinfoMap.get("nickname"))
                        && user.getSex().equals(userinfoMap.get("sex"))
                        && user.getProvince().equals(userinfoMap.get("province"))
                        && user.getCity().equals(userinfoMap.get("city"))
                        && user.getCountry().equals(userinfoMap.get("country"))){ // 信息未变动
                    resultMap.put("user",user);
                }else{ //信息变动 ，更新
                    snoUserService.updateByMap(userinfoMap);
                    user = snoUserService.getByOpenId(openid);
                }
            }
            resultMap.put("user",new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create().toJson(user));
        }
        resultMap.put("openid",openid);
        apiResultVO.setData(resultMap);
        return apiResultVO;
    }

    @GetMapping("/token")
    public ApiResultVO getUserinfoByToken(HttpServletRequest request){
        ApiResultVO apiResultVO = new ApiResultVO();
        String userId = request.getHeader("token");
        SnoUserPO user = null;
        if (!StringUtils.isEmpty(userId)) {
            user = snoUserService.getByOpenId(userId);
        }
        if(user!=null){
            apiResultVO.setData(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create().toJson(user));
        }
        return apiResultVO;
    }

    /** 前端微信jssdk签名 */
    @GetMapping("getJssdk")
    public ApiResultVO getJssdk(@RequestParam("url") String url) throws IOException, NoSuchAlgorithmException {
        ApiResultVO apiResultVO = new ApiResultVO();

        String noncestr = SnoUtil.getRandomString(32);
        String timestamp = String.valueOf(new Date().getTime());
        String beforeSha = "jsapi_ticket=JSTICKE&noncestr=NONSTR&timestamp=STAMP&url=URL";
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(beforeSha.replace("JSTICKE",getTicket()).replace("NONSTR",noncestr).replace("STAMP",timestamp).replace("URL",url).getBytes());
        byte[] byteResult = digest.digest();

        //因为加密完为字节数组，需要转化为字符串
        String signature = SnoUtil.convertbyte2String(byteResult);

        Map<String, String> resMap = new HashMap<>();
        resMap.put("signature",signature);
        resMap.put("nonceStr",noncestr);
        resMap.put("timestamp",timestamp);

        apiResultVO.setData(resMap);
        return apiResultVO;
    }

    /** 微信统一下单 */
    @PostMapping("unifiedorder")
    @Transactional
    public ApiResultVO unifiedorder(@RequestBody SnoDonationVO donate, @LoginUser SnoUserPO user) throws Exception {
        ApiResultVO apiResultVO = new ApiResultVO();
        String unifiedorderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

        /** 1、调用微信下单接口，将返回交易数据入库，状态为处理中 */
        SnoGiftPO gift = snoGiftService.getById(donate.getGiftId());

        String outTradeNo = SnoUtil.getUniqueOrderId();

        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid",GlobalValue.APP_ID);
        packageParams.put("mch_id",GlobalValue.MCH_ID);
        packageParams.put("nonce_str",SnoUtil.getRandomString(32));
        packageParams.put("body", "趣教育平台礼物 " + gift.getName() + donate.getGiftNum() + "个");
        packageParams.put("out_trade_no",outTradeNo);
        packageParams.put("total_fee","1");  //todo
        packageParams.put("openid",user.getOpenid());
        packageParams.put("spbill_create_ip","47.94.249.68");
        packageParams.put("notify_url","http://www.djtp.com/api/wechat/notify");
        packageParams.put("trade_type","JSAPI");

        String sign = SnoUtil.createSign(packageParams);
        packageParams.put("sign", sign);
        String requestXML = SnoUtil.getRequestXml(packageParams);
        logger.info("统一下单请求内容：{}",requestXML);

        String res = SnoUtil.httpPOstMethod(unifiedorderUrl, requestXML);
//        String res = "<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
//                "<return_msg><![CDATA[OK]]></return_msg>\n" +
//                "<appid><![CDATA[wxda38bb8a650afb21]]></appid>\n" +
//                "<mch_id><![CDATA[1489378952]]></mch_id>\n" +
//                "<nonce_str><![CDATA[oAyha1oCxO4nw07F]]></nonce_str>\n" +
//                "<sign><![CDATA[C87C9BB65650280D8D9DBE1F530B2B0D]]></sign>\n" +
//                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
//                "<prepay_id><![CDATA[wx31171438796084629f27ae074315590100]]></prepay_id>\n" +
//                "<trade_type><![CDATA[JSAPI]]></trade_type>\n" +
//                "</xml>";

        /** 入库 */
        Map<String,String> unifiedOrderMap = SnoUtil.xmlToMap(res);

        SnoWechatTradePO po = new SnoWechatTradePO();
        po.setUserId(user.getId());
        po.setOpenid(user.getOpenid());
        po.setOutTradeNo(outTradeNo);
        po.setStatus(1);
        po.setTotalFee(1);//todo
        po.setPrepayId(unifiedOrderMap.get("prepay_id"));
        po.setTradeType(unifiedOrderMap.get("trade_type"));

        Integer tradeId = snoWechatTradeService.save(po);
        if (tradeId > 0) {
            /** 2、插入礼物记录表记录，状态为未支付 */
            SnoReplyDonationPO donation = new SnoReplyDonationPO();
            donation.setReplyId(donate.getReplyId());
            donation.setUserId(user.getId());
            donation.setNickname(user.getNickname());
            donation.setAvatar(user.getAvatar());
            donation.setGiftId(donate.getGiftId());
            donation.setGiftName(gift.getName());
            donation.setGiftNum(donate.getGiftNum());
            donation.setGiftImg(gift.getImg());
            donation.setTotalFee(gift.getWorth() * donate.getGiftNum());
            donation.setOutTradeNo(outTradeNo);

            snoReplyDonationService.save(donation);

            /** 3、返回值 */
            Map<String, Object> resMap = wxSmallPayByPrepayId(unifiedOrderMap.get("prepay_id"));
            resMap.put("totalFee",1); //todo
            apiResultVO.setData(resMap);
        }else{
            apiResultVO.setCode(-1);
        }
        return apiResultVO;
    }

    /** 微信统一回调接口
     *  <xml>
     *      <appid><![CDATA[wxda38bb8a650afb21]]></appid>
     *      <bank_type><![CDATA[CFT]]></bank_type>
     *      <cash_fee><![CDATA[1]]></cash_fee>
     *      <fee_type><![CDATA[CNY]]></fee_type>
     *      <is_subscribe><![CDATA[Y]]></is_subscribe>
     *      <mch_id><![CDATA[1489378952]]></mch_id>
     *      <nonce_str><![CDATA[IYQpP2gm30J1U788K7CjSWhV8BRN65sc]]></nonce_str>
     *      <openid><![CDATA[oy6Tg0cMQXrTD2Z2NZB-aXFhuW_Y]]></openid>
     *      <out_trade_no><![CDATA[sno20190603140640Ri7xB4j0]]></out_trade_no>
     *      <result_code><![CDATA[SUCCESS]]></result_code>
     *      <return_code><![CDATA[SUCCESS]]></return_code>
     *      <sign><![CDATA[00E6FB932D57755F44BD37E95DE72E4C]]></sign>
     *      <time_end><![CDATA[20190603140647]]></time_end>
     *      <total_fee>1</total_fee>
     *      <trade_type><![CDATA[JSAPI]]></trade_type>
     *      <transaction_id><![CDATA[4200000292201906032674387676]]></transaction_id>
     *   </xml>
     */
    @PostMapping("notify")
    @Transactional
    public void notify(@RequestBody String wechatNotify,HttpServletResponse resp) throws Exception {
        logger.info("接收微信支付结果通知:{}",wechatNotify);
        String resultXml = null;
        Map<String, String> wechatNotifyMap = SnoUtil.xmlToMap(wechatNotify);
        if(wechatNotifyMap.get("return_code").equals("SUCCESS")){
            if(wechatNotifyMap.get("result_code").equals("SUCCESS")){
                /** 1、支付成功，修改交易表 */
                Integer i = snoWechatTradeService.updateTradeSuccess(wechatNotifyMap);
                if (i > 0) {
                    SnoReplyDonationPO donationPO = snoReplyDonationService.getByOutTradeNo(wechatNotifyMap.get("out_trade_no"));

                    /** 2、修改礼物记录表状态为已支付 */
                    Integer j = snoReplyDonationService.updateDonateSuccess(wechatNotifyMap);
                    /** 3、累计礼物金额 */
                    Integer k = snoReplyService.updatePaidFee(Integer.parseInt(wechatNotifyMap.get("total_fee")),donationPO.getReplyId());
                }
                SortedMap<Object,Object> res = new TreeMap<>();
                res.put("return_code","SUCCESS");
                res.put("return_msg","OK");
                resultXml = SnoUtil.getRequestXml(res);
            }
        }

        try {
            BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
            out.write(resultXml.getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /** 微信支付签名返回前端 */
    private Map<String, Object> wxSmallPayByPrepayId(String prepayId) throws Exception {
        Map<String, Object> wxMap = new HashMap<>();
        Long timeStamp = System.currentTimeMillis() / 1000;
        String nonceStr = SnoUtil.getRandomString(32);
        String prePackage = "prepay_id=" + prepayId;
        wxMap.put("appId",  GlobalValue.APP_ID);
        wxMap.put("timeStamp", timeStamp);
        wxMap.put("nonceStr", nonceStr);
        wxMap.put("package", prePackage);
        wxMap.put("signType", "MD5");
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appId",  GlobalValue.APP_ID);
        packageParams.put("nonceStr", nonceStr);
        packageParams.put("package", prePackage);
        packageParams.put("signType", "MD5");
        packageParams.put("timeStamp", timeStamp);
        wxMap.put("paySign", SnoUtil.createSign(packageParams));
        return wxMap;
    }


    /** 微信jsapi_ticket获取
     *  ticketMap {
     *      "errcode":0,
     *      "errmsg":"ok",
     *      "ticket":"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA",
     *      "expires_in":7200
     *  }
     */
    private String getTicket() throws IOException {
        String jsapiTicket = null;
        if(LocalCache.containsKey("jsapiTicket")){
            jsapiTicket = (String) LocalCache.get("jsapiTicket");
        }else{
            String accessToken = SnoUtil.getAccessToken();
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
            String res = SnoUtil.httpGetMethod(url.replace("ACCESS_TOKEN", accessToken));
            Map<String, String> ticketMap = new Gson().fromJson(res, HashMap.class);
            logger.info("获取微信jsapi_ticket接口返回：{}", ticketMap);
            LocalCache.put("jsapiTicket",ticketMap.get("ticket"),7200);
            jsapiTicket = ticketMap.get("ticket");
        }
        return jsapiTicket;
    }






}
