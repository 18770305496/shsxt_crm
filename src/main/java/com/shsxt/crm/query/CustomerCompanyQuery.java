package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;

public class CustomerCompanyQuery extends BaseQuery {

    private String phone;

    private String mobile;

    private String companyCode;

    private String companyNameCn;

    public String getCompanyNameCn() {
        return companyNameCn;
    }

    public void setCompanyNameCn(String companyNameCn) {
        this.companyNameCn = companyNameCn;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
