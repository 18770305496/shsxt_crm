package com.shsxt.crm.service;

import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.CustomerCompanyMapper;
import com.shsxt.crm.dao.CustomerLossMapper;
import com.shsxt.crm.dao.CustomerMapper;
import com.shsxt.crm.po.Customer;
import com.shsxt.crm.po.CustomerLoss;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xlf on 2018/10/22.
 */
@Service
public class CustomerService extends BaseService<Customer> {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerLossMapper customerLossMapper;
    /**
     * 添加流失客户
     * @return
     */
    public void addLossCustomers(){
        /***
         * 1. 查询所有流失客户
         * 2. 批量插入客户流失表
         * 3. 把查出的客户state状态变更为1
         * */
        List<Customer> customerList = customerMapper.queryLossCustomers();
        if(!CollectionUtils.isEmpty(customerList)){
            // 存流失客户列表
            List<CustomerLoss> customerLossList = new ArrayList<>();

            for(Customer customer : customerList){
                CustomerLoss customerLoss = new CustomerLoss();
                customerLoss.setCusNo(customer.getKhno());
                customerLoss.setCusName(customer.getName());
                customerLoss.setCusManager(customer.getCusManager());
                customerLoss.setState(0);// 预流失
                customerLoss.setIsValid(1);// 有效
                customerLoss.setCreateDate(new Date());
                customerLoss.setUpdateDate(new Date());
                customerLossList.add(customerLoss);
            }
            AssertUtil.isTrue(customerLossMapper.saveBatch(customerLossList)<customerLossList.size(), CrmConstant.OPS_FAILED_MSG);
            AssertUtil.isTrue(customerMapper.updateCustomerState(customerList)<customerList.size(), CrmConstant.OPS_FAILED_MSG);
        }
    }

    public void saveOrUpdateCustomer(Customer customer){
        // 参数校验省略....
        customer.setUpdateDate(new Date());
        Integer id = customer.getId();

        if(null==id){
            customer.setState(0);// 未流失
            customer.setIsValid(1);// 有效
            customer.setCreateDate(new Date());//创建时间
            customer.setKhno(new Integer(MathUtil.genereateKhCode()).toString());// 客户编号

            AssertUtil.isTrue(customerMapper.save(customer)<1, CrmConstant.OPS_FAILED_MSG);
        }else{
            AssertUtil.isTrue(customerMapper.update(customer)<1, CrmConstant.OPS_FAILED_MSG);
        }

    }

    public List<Map> queryCustomerLevel(String dicName){

        return customerMapper.queryCustomerLevel(dicName);
    }

    public List<Map> queryCustomerLevelNums(){

        return customerMapper.queryCustomerLevelNums();
    }
}
