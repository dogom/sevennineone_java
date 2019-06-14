package com.gfang.sevennineone.config;

import com.gfang.sevennineone.Components.LoginUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by Administrator on 2019/5/21.
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private LoginUserMethodArgumentResolver loginUserMethodArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserMethodArgumentResolver);
    }
}
