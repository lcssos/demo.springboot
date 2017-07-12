package com.hhmedic.demo.util;

import com.hhmedic.demo.entity.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by lcssos on 15/12/22.
 */
public class ShiroUtil {

    public static Long getUuid(){
        Subject currentUser = SecurityUtils.getSubject();
        ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
        return shiroUser.getUuid();
    }

	public static boolean isAuthenticated(){
		Subject currentUser = SecurityUtils.getSubject();
		return currentUser.isAuthenticated();
	}

    public static ShiroUser getUser(){
        Subject currentUser = SecurityUtils.getSubject();
        return  (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
    }

}
