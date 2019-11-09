package com.gfang.sevennineone.controller;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoActivityLinkPO;
import com.gfang.sevennineone.model.po.SnoActivityPrizePO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoActivityLinkService;
import com.gfang.sevennineone.service.SnoActivityPrizeService;
import com.gfang.sevennineone.util.SnoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/27.
 */
@RestController
@RequestMapping("snoActivityPrize")
public class SnoActivityPrizeController {

    @Autowired
    private SnoActivityPrizeService snoActivityPrizeService;

    @PostMapping("/save")
    public ApiResultVO save(@LoginUser SnoUserPO user,@RequestBody SnoActivityPrizePO po) throws IOException {
        ApiResultVO apiResultVO = new ApiResultVO();
        po.setImg(SnoUtil.downloadWxImage(po.getImg()));
        if(po.getId()!=null){
            snoActivityPrizeService.update(po);
            apiResultVO.setData(po.getId());
        }else{
            po.setUserId(user.getId());
            Integer i = snoActivityPrizeService.save(po);
            apiResultVO.setData(i);
        }
        return apiResultVO;
    }

    @GetMapping("delete")
    public ApiResultVO delete(@RequestParam("id") Integer id){
        ApiResultVO apiResultVO = new ApiResultVO();
        SnoActivityPrizePO po = new SnoActivityPrizePO();
        po.setId(id);
        po.setIsDelete(1);
        Integer i = snoActivityPrizeService.update(po);
        apiResultVO.setData(i);
        return apiResultVO;
    }

    @GetMapping("listByActivityId")
    public ApiResultVO listByActivityId(@RequestParam("aid") Integer aid){
        ApiResultVO apiResultVO = new ApiResultVO();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("activityId",aid);
        List<SnoActivityPrizePO> list = snoActivityPrizeService.listByMap(paramMap);

        Map<String, Object> resMap = new HashMap<>();
        resMap.put("list",list);
        apiResultVO.setData(resMap);
        return apiResultVO;
    }
//
//   @GetMapping("getById")
//    public ApiResultVO getById(@RequestParam("id") Integer id){
//        ApiResultVO apiResultVO = new ApiResultVO();
//        SnoArticlePO article = snoArticleService.getById(id);
//        apiResultVO.setData(article);
//        return apiResultVO;
//    }


}
