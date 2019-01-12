package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.service.CustomerServeService;
import com.shsxt.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by xlf on 2018/10/23.
 */
@Controller
@RequestMapping("report")
public class ReportController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerServeService customerServeService;

    @RequestMapping("{state}")
    public String index(@PathVariable Integer state){
        if(0==state){

        }else if(1==state){
            return "report_customerLevel";
        }else if(2==state){
            return "report_serve";
        }

        return "error";
    }

    @RequestMapping("queryCustomerLevelNums")
    @ResponseBody
    public List<Map> queryCustomerLevelNums(){
        return customerService.queryCustomerLevelNums();
    }

    @RequestMapping("queryServeType")
    @ResponseBody
    public List<Map> queryServeType(){
        return customerServeService.queryServeType();
    }
}
