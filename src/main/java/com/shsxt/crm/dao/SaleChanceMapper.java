package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.po.SaleChance;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SaleChanceMapper extends BaseDao<SaleChance> {

    public List<Map> queryAllCustomerManager();
    public Integer updateSaleChanceDevResult(SaleChance saleChance);
}