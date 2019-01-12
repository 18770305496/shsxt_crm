package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.po.Customer;
import com.shsxt.crm.query.CustomerOrderQuery;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.service.CustomerOrderService;
import com.shsxt.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by xlf on 2018/10/22.
 */
@Controller
@RequestMapping("customerOrder")
public class CustomerOrderController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("index")
    public String index(Integer cusId, Model model){
        Customer customer = customerService.queryById(cusId);
        model.addAttribute(customer);
        return "customer_order";
    }

    @RequestMapping("queryCustomerOrdersByParams")
    @ResponseBody
    public Map<String, Object> queryCustomerOrdersByParams(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            CustomerOrderQuery query) {
        query.setPageNum(page);
        query.setPageSize(rows);
        return customerOrderService.queryForPage(query);
    }
}
