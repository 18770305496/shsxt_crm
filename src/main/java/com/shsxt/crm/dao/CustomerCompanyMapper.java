package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.po.CustomerCompany;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCompanyMapper  extends BaseDao<CustomerCompany> {

    int deleteByPrimaryKey(Integer ids);

    int insert(CustomerCompany record);

    int insertSelective(CustomerCompany record);

    CustomerCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerCompany record);

    int updateByPrimaryKey(CustomerCompany record);


}