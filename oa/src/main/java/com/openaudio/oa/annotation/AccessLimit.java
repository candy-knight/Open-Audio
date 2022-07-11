package com.openaudio.oa.annotation;


import java.lang.annotation.*;

/**
 * redis 接口限流
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimit {
    /**
     * 单位时间--秒
     */
    int seconds();

    /**
     * 单位时间内最大请求数
     */
    int maxCount();
}
