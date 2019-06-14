package com.gfang.sevennineone.controller;

import com.gfang.sevennineone.common.ApiResultVO;
import com.gfang.sevennineone.common.OSSUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2019/5/5.
 */
@RestController
@RequestMapping("image")
public class SnoImageController {

    @PostMapping("/upload")
    public ApiResultVO upload(@RequestParam("file") MultipartFile multipartFile){
        return OSSUtil.upload("default",multipartFile);
    }
}
