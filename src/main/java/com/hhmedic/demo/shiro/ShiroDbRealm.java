/*******************************************************************************
 * Copyright (c) 2015 HH-Medic
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hhmedic.demo.shiro;

import com.hhmedic.demo.entity.ShiroUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ShiroDbRealm extends AuthorizingRealm {


    /**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				ShiroUser.builder().loginname("zhangsan").name("张三").uuid(10000L).build(),
				"b2ee60370ad57d9bc3877e9024c507ab99303a64", //密码
				ByteSource.Util.bytes(""),//salt=username+salt
				getName()  //realm name
		);
		return authenticationInfo;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		return null;
	}


	  /**
	   * 更新用户授权信息缓存.
	   */
	  public void clearCachedAuthorizationInfo(Object principal) {
	    SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
	    clearCachedAuthorizationInfo(principals);
	  }

	  /**
	   * 清除所有用户授权信息缓存.
	   */
	  public void clearAllCachedAuthorizationInfo() {
	    Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
	    if (cache != null) {
	      for (Object key : cache.keys()) {
	        cache.remove(key);
	      }
	    }
	  }

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
//	@PostConstruct
//	public void initCredentialsMatcher() {
//		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(AccountService.HASH_ALGORITHM);
//		matcher.setHashIterations(AccountService.HASH_INTERATIONS);
//
//		setCredentialsMatcher(matcher);
//	}

//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
//


	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
}
