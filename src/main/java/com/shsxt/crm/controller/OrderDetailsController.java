package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.query.OrderDetailsQuery;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by xlf on 2018/10/22.
 */
@Controller
@RequestMapping("orderDetails")
public class OrderDetailsController extends BaseController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping("queryOrderDetailsByParams")
    @ResponseBody
    public Map<String, Object> queryOrderDetailsByParams(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            OrderDetailsQuery query) {
        query.setPageNum(page);
        query.setPageSize(rows);
        return orderDetailsService.queryForPage(query);
    }
}
