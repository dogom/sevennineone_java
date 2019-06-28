package com.gfang.sevennineone.controller;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.model.po.SnoActivityLinkPO;
import com.gfang.sevennineone.model.po.SnoArticlePO;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoActivityLinkService;
import com.gfang.sevennineone.service.SnoArticleService;
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
@RequestMapping("snoActivityLink")
public class SnoActivityLinkController {

    @Autowired
    private SnoActivityLinkService snoActivityLinkService;

    @PostMapping("/save")
    public ApiResultVO save(@RequestBody SnoActivityLinkPO po) throws IOException {
        ApiResultVO apiResultVO = new ApiResultVO();
        po.setImg(SnoUtil.downloadWxImage(po.getImg()));
        if(po.getId()!=null){
            snoActivityLinkService.update(po);
            apiResultVO.setData(po.getId());
        }else{
            Integer i = snoActivityLinkService.save(po);
            apiResultVO.setData(i);
        }
        return apiResultVO;
    }

//    @GetMapping("listMyArticle")
//    public ApiResultVO listMyArticle(@LoginUser SnoUserPO user,
//                                     @RequestParam(value="current",defaultValue = "1") Integer current,
//                                     @RequestParam(value="rowCount",defaultValue = "10") Integer rowCount){
//        ApiResultVO apiResultVO = new ApiResultVO();
//
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("userId",user.getId());
//        paramMap.put("start",(current-1)*rowCount);
//        paramMap.put("rowCount",rowCount);
//        List<SnoArticlePO> list = snoArticleService.listByMap(paramMap);
//        Integer total = snoArticleService.getCountByMap(paramMap);
//
//        Map<String, Object> resMap = new HashMap<>();
//        resMap.put("list",list);
//        resMap.put("total",total);
//        apiResultVO.setData(resMap);
//        return apiResultVO;
//    }
//
    @GetMapping("delete")
    public ApiResultVO deleteLink(@RequestParam("id") Integer id){
        ApiResultVO apiResultVO = new ApiResultVO();
        Integer i = snoActivityLinkService.delete(id);
        apiResultVO.setData(i);
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
