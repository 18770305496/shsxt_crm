package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.po.CustomerAddress;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressMapper extends BaseDao<CustomerAddress>{
    int deleteByPrimaryKey(Integer id);

    boolean insert(CustomerAddress record);

    int insertSelective(CustomerAddress record);

    CustomerAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerAddress record);

    int updateByPrimaryKey(CustomerAddress record);
}