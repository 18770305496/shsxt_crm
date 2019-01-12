package com.shsxt.crm.model;

/**
 * Created by xlf on 2018/10/13.
 */
public class UserInfo {
    private String userIdStr; // id 的加密字符串
    private String userName;
    private String realName;

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
