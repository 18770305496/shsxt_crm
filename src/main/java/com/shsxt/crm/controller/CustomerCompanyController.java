package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.CustomerCompany;
import com.shsxt.crm.query.CustomerCompanyQuery;
import com.shsxt.crm.service.CustomerCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("customerCompany")
public class CustomerCompanyController extends BaseController {

    @Autowired
    private CustomerCompanyService customerCompanyService;
    /**
     * 公司信息列表页面
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "customer_company";
    }
    /**
     * 公司信息列表数据
     * @param page
     * @param rows
     * @param query
     * @return
     */
    @RequestMapping("queryCustomersByParams")
    @ResponseBody
    public Map<String, Object> queryCustomersByParams(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            CustomerCompanyQuery query) {
        query.setPageNum(page);
        query.setPageSize(rows);
        return customerCompanyService.queryForPage(query);
    }

    /**
     * 保存客户公司信息 或者更新公司信息
     * @param customer
     * @return
     */
    @RequestMapping("saveOrUpdateCompanyCustomer")
    @ResponseBody
    public ResultInfo saveOrUpdateCompanyCustomer(CustomerCompany customerCompany){

        //保存客户信息
        customerCompanyService.saveOrUpdateCustomerCompany(customerCompany);

        return success(CrmConstant.OPS_SUCCESS_MSG);
    }

    /**
     * 删除公司信息
     * @param ids
     * @return
     */
    @RequestMapping("deleteCustomerBatch")
    @ResponseBody
    public ResultInfo deleteCustomerBatch(Integer[] ids){
        customerCompanyService.deleteBatch(ids);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }
}
