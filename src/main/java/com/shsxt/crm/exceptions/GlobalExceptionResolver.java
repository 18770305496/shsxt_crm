package com.shsxt.crm.exceptions;

import com.alibaba.fastjson.JSON;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.model.ResultInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by xlf on 2018/10/15.
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        ModelAndView mv = createDefaultModelAndView(request, ex);

        /**
         * 1. 区分是什么异常
         * 2. 区分是页面请求还是json请求
         * */

        if (ex instanceof LoginException){
            mv.addObject("errorMsg", CrmConstant.USER_NOT_LOGIN_MSG);
            mv.setViewName("login_error");
            return mv;
        }
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
            if(null==responseBody){
                // 普通页面请求
                if(ex instanceof ParamsException){
                    ParamsException e = (ParamsException) ex;
                    mv.addObject("errorMsg", e.getMsg());
                }
            }else{
                // json请求
                ResultInfo info = new ResultInfo();
                info.setCode(300);
                info.setMsg("系统繁忙");
                if(ex instanceof ParamsException){
                    ParamsException e = (ParamsException) ex;
                    info.setMsg(e.getMsg());
                }
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");
                PrintWriter pw =null;

                try {
                    pw = response.getWriter();
                    pw.write(JSON.toJSONString(info));
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(null!=pw){
                        pw.close();
                    }
                }
                return null;
            }
        }


        return mv;
    }

    private ModelAndView createDefaultModelAndView(HttpServletRequest request, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");// 错误页面
        mv.addObject("errorMsg", "系统繁忙"); // 错误信息
        mv.addObject("errorCode", 300); // 错误码
        mv.addObject("ctx", request.getContextPath()); // 上下文路径
        mv.addObject("uri", request.getRequestURI()); // 请求路径
        System.out.println("==========================");
        System.out.println("uri: "+request.getRequestURI());
        System.out.println("==========================");
        return mv;
    }
}
