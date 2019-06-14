package com.gfang.sevennineone.Components;

import com.gfang.sevennineone.anotation.LoginUser;
import com.gfang.sevennineone.model.po.SnoUserPO;
import com.gfang.sevennineone.service.SnoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Administrator on 2019/5/21.
 */
@Component
public class LoginUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private SnoUserService snoUserService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.getParameterType().isAssignableFrom(SnoUserPO.class) && methodParameter.hasParameterAnnotation(LoginUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
        String openid = nativeWebRequest.getHeader("token");
        SnoUserPO user = snoUserService.getByOpenId(openid);
        return user;
    }
}
