package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;

import java.util.Date;

/**
 * Created by xlf on 2018/10/23.
 */
public class CustomerLossQuery extends BaseQuery {

    private String cusNo;

    private String cusName;

    private String createDate;

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
