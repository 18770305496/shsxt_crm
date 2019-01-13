package com.shsxt.crm.service;

import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.CustomerAddressMapper;
import com.shsxt.crm.po.CustomerAddress;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerAddressService extends BaseService<CustomerAddress> {

    @Autowired
    private CustomerAddressMapper customerAddressMapper;
    /**
     * 新增或更新客户公司地址信息
     * @param customerAddress
     */
    public void saveOrUpdateCustomerAddress(CustomerAddress customerAddress){

        if(customerAddress.getId()==null){
            // 公司主键为空 新增业务
            customerAddress.setCreateTime(new Date());//创建时间
            customerAddress.setCustomerId(MathUtil.genereateKhCode());//设置主键
            customerAddress.setYn("Y");//设置Yn数据是否有效 Y显示页面
            AssertUtil.isTrue(customerAddressMapper.insert(customerAddress), CrmConstant.OPS_FAILED_MSG);
        }else{
            // 更新业务
            int i=customerAddressMapper.updateByPrimaryKeySelective(customerAddress);
            //i==1 更新成功 i==0否则失败
            boolean result=i<1?true:false;
            AssertUtil.isTrue( result, CrmConstant.OPS_FAILED_MSG);
        }
    }

}
