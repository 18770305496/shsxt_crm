package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;

public class CustomerAddressQuery extends BaseQuery {

    private String mobile;

    private String name;

    private String phone;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
