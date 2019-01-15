package com.shsxt.crm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tony on 2016/8/24.
 */
public class MathUtil {

    /**
     * 生产客户编号
     *
     * @return
     */
    public static String genereateKhCode() {
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = datetimeFormat.format(new Date());
        String code = "KH" + date + random(100, 999);
        return code;
    }

    /**
     * 生成随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int random(int min, int max) {
        return (int) Math.round(Math.random() * max + min);
    }
}
