package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;

/**
 * Created by xlf on 2018/10/22.
 */
public class OrderDetailsQuery extends BaseQuery {
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
