package com.shsxt.crm.interceptors;

import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.SysLogMapper;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.po.SysLog;
import com.shsxt.crm.po.User;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 日志拦截器作用
 */
public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    SysLogMapper sysLogMapper;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("preHandler======LogInterceptor");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle======LogInterceptor");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("afterCompletion======LogInterceptor");

        //登陆成功获取userId
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        //根据用户id 获取用户信息
        UserDto userDto=userService.queryById(userId);

        //新增系统日志
        SysLog log=new SysLog();
        log.setType(e == null ? CrmConstant.TYPE_ACCESS : CrmConstant.TYPE_EXCEPTION);
        log.setRemoteAddr(StringUtils.getRemoteAddr(request));
        log.setUserAgent(request.getHeader("user-agent"));
        log.setRequestUri(request.getRequestURI());
        log.setParams(StringUtils.getParamsString(request.getParameterMap()));
        log.setMethod(request.getMethod());
        //设置用户名
        log.setCreateBy(userDto.getUserName());
        log.setCreateDate(new Date());
        log.setTitle("log");

        //新增系统日志记录到数据库
        sysLogMapper.insert(log);
    }
}
