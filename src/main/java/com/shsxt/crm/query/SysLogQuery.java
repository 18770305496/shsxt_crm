package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;

public class SysLogQuery extends BaseQuery {

    private String title;

    private String createBy;

    private String userAgent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
