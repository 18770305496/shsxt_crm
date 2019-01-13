package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.CustomerAddress;
import com.shsxt.crm.query.CustomerAddressQuery;
import com.shsxt.crm.service.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("customerAddress")
public class CustomerAddressController extends BaseController{

    @Autowired
    private CustomerAddressService customerAddressService;

    /**
     * 找到公司地址页面
     */
    @RequestMapping("index")
    public String index(){
        return "customer_address";
    }
    /**
     *公司地址列表数据
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
            CustomerAddressQuery query) {
        query.setPageNum(page);
        query.setPageSize(rows);
        return customerAddressService.queryForPage(query);
    }

    /**
     * 保存客户公司信息 或者更新公司信息
     * @param customerAddress
     * @return
     */
    @RequestMapping("saveOrUpdateCompanyAddress")
    @ResponseBody
    public ResultInfo saveOrUpdateCompanyAddress(CustomerAddress customerAddress){

        //保存客户信息
        customerAddressService.saveOrUpdateCustomerAddress(customerAddress);

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
        customerAddressService.deleteBatch(ids);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }

}
