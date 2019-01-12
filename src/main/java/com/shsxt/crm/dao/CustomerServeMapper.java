package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.po.CustomerServe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerServeMapper extends BaseDao<CustomerServe> {
    public List<Map> queryServeType();
}