package com.shsxt.crm.interceptors;

import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * Created by xlf on 2018/10/15.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        /***
         * 判断用户是否登陆
         * */
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        AssertUtil.isNotLogin(null==userId || null==userService.queryById(userId), CrmConstant.USER_NOT_LOGIN_MSG);
        return true;// 继续执行
    }
}
