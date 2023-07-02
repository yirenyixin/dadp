package com.gientech.core.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限注解的写法如下：
 * 
 * 【1--鉴权单个权限】@PreAuthorize(hasAuth = "sysConfig") // 菜单id或功能id
 * 
 * 【2--数组鉴权多个权限：】@PreAuthorize(hasAnyAuth = { "sysConfig", "login" }) // 菜单id或功能id数组
 * 
 * 【3--鉴权单多个角色】@PreAuthorize(hasRole = "admin")// 角色ID
 * 
 * 【4--鉴权多个角色】@PreAuthorize(hasRole = { "admin", "test" })// 角色ID数组
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAuthorize {
	/**
	 * 验证用户是否具备某权限
	 */
	public String hasAuth() default "";

	/**
	 * 验证用户是否具有以下任意一个权限
	 */
	public String[] hasAnyAuth() default {};

	/**
	 * 判断用户是否拥有某个角色
	 */
	public String hasRole() default "";

	/**
	 * 验证用户是否具有以下任意一个角色
	 */
	public String[] hasAnyRole() default {};
}