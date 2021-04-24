package com.red.annotaion;

import com.red.config.myconst.RoleConst;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireRole {

    RoleConst value() default RoleConst.ROLE_TYPE_USER;

}
