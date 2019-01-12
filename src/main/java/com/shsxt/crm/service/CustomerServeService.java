package com.shsxt.crm.service;

import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.CustomerServeMapper;
import com.shsxt.crm.dao.UserMapper;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.po.CustomerServe;
import com.shsxt.crm.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xlf on 2018/10/23.
 */
@Service
public class CustomerServeService extends BaseService<CustomerServe> {

    @Autowired
    private CustomerServeMapper customerServeMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 添加或者更新CustomerServe
     * @param customerServe
     */
    public void saveOrUpdateCustomerServe(CustomerServe customerServe, Integer userId){

        customerServe.setUpdateDate(new Date());

        Integer id = customerServe.getId();
        UserDto userDto = userMapper.queryById(userId);
        if(null==id){
            customerServe.setCreatePeople(userDto.getUserName());// 创建人
            customerServe.setState("1");// 初始状态1
            customerServe.setIsValid(1);// 有效状态1
            customerServe.setCreateDate(new Date());
            AssertUtil.isTrue(customerServeMapper.save(customerServe)<1, CrmConstant.OPS_FAILED_MSG);
        }else{
            /**
             * state变化
             * 1 -> 2
             * 2 -> 3
             * */
            String state = customerServe.getState();
            if(state.equals("1")){
                customerServe.setState("2");
                customerServe.setAssignTime(new Date());// 分配时间
            }else if(state.equals("2")){
                customerServe.setState("3");
                customerServe.setServiceProceTime(new Date());//处理时间
                customerServe.setServiceProcePeople(userDto.getUserName());//处理人
            }else if(state.equals("3")){
                customerServe.setState("4");
            }

            AssertUtil.isTrue(customerServeMapper.update(customerServe)<1, CrmConstant.OPS_FAILED_MSG);
        }
    }

    public List<Map> queryServeType(){

        return customerServeMapper.queryServeType();
    }
}
