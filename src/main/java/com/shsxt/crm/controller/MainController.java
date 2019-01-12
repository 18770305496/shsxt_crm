package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.po.User;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xlf on 2018/10/13.
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("main")
    public String index(HttpServletRequest request) {
        /***
         * 查询用户,存入request作用域
         * */
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        User user = userService.queryById(userId);
        request.setAttribute("user", user);
        // 查询权限列表
        List<String> permissions = userService.queryAllAclValueByUserId(userId);
        System.out.println("===================================");
        System.out.println(permissions.toString());
        System.out.println("===================================");
        // 放入session中
        request.getSession().setAttribute(CrmConstant.USER_PERMISSIONS, permissions);
        return "main";
    }
}
