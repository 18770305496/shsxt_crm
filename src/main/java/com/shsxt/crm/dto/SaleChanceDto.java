package com.shsxt.crm.dto;

import com.shsxt.crm.po.SaleChance;

/**
 * Created by xlf on 2018/10/15.
 */
public class SaleChanceDto extends SaleChance {
    private String trueName;

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
}
