package com.sly.hial.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录进入许可
 * 加上此注解的方法,只有用户登录了才可以进入
 * @author sly
 * @time 2019年4月28日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginPermission {

}
