package com.shsxt.crm.base;

/**
 * Created by lp on 2018/1/3.
 */
public class BaseQuery {
    private Integer pageNum=1;
    private Integer pageSize=10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
