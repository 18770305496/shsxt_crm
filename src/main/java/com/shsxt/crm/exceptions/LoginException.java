package com.shsxt.crm.exceptions;

import com.shsxt.crm.constants.CrmConstant;

public class LoginException extends RuntimeException {
    private Integer code= CrmConstant.USER_NOT_LOGIN_CODE;
    private String msg= CrmConstant.USER_NOT_LOGIN_MSG;

    public LoginException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public LoginException(Integer code) {
        super(CrmConstant.USER_NOT_LOGIN_MSG);
        this.code = code;
    }

    public LoginException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
