package com.shsxt.crm.service;

import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.CustomerCompanyMapper;
import com.shsxt.crm.po.CustomerCompany;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerCompanyService extends BaseService<CustomerCompany> {

    @Autowired
    private CustomerCompanyMapper customerCompanyMapper;

    /**
     * 新增或更新客户公司信息
     * @param customerCompany
     */
    public void saveOrUpdateCustomerCompany(CustomerCompany customerCompany){

        if(customerCompany.getId()==null){
            // 公司主键为空 新增业务
            customerCompany.setCreateTime(new Date());//创建时间
            customerCompany.setCompanyCode(MathUtil.genereateKhCode());//设置公司编码
            customerCompany.setYn("Y");//设置Yn数据是否有效 Y显示页面
            int i=customerCompanyMapper.insert(customerCompany);
            //i==1 新增成功 i==0否则失败
            boolean result=i<1?true:false;

            AssertUtil.isTrue( result, CrmConstant.OPS_FAILED_MSG);
        }else{
            // 更新业务
            int i=customerCompanyMapper.updateByPrimaryKeySelective(customerCompany);
            //i==1 更新成功 i==0否则失败
            boolean result=i<1?true:false;
            AssertUtil.isTrue( result, CrmConstant.OPS_FAILED_MSG);
        }
    }

}
