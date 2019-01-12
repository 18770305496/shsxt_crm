package com.shsxt.crm.utils;


import com.shsxt.crm.exceptions.LoginException;
import com.shsxt.crm.exceptions.ParamsException;

public class AssertUtil {

    public static void isTrue(Boolean flag,String msg){
        if(flag){
            throw new ParamsException(msg);
        }
    }

    public static  void isTrue(Boolean flag,String msg,Integer code){
        if(flag){
            throw new ParamsException(code,msg);
        }
    }

    public static void isNotLogin(Boolean flag,String msg){
        if(flag){
            throw new LoginException(msg);
        }
    }


}
