package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;

/**
 * Created by xlf on 2018/10/22.
 */
public class CustomerQuery extends BaseQuery {
    private String khno;
    private String name;
    private String fr;

    public String getKhno() {
        return khno;
    }

    public void setKhno(String khno) {
        this.khno = khno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }
}
