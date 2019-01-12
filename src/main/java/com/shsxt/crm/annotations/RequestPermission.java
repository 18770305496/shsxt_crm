package com.shsxt.crm.annotations;

import java.lang.annotation.*;

/**
 * Created by xlf on 2018/10/20.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestPermission {
    String aclValue() default "";
}
