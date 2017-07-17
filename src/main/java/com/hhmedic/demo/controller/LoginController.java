package com.hhmedic.demo.controller;

import com.hhmedic.demo.response.Response;
import com.hhmedic.demo.response.ResponseEnum;
import com.hhmedic.demo.response.ResponseFactory;
import com.hhmedic.demo.util.ShiroUtil;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lcssos on 17-7-12.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    @ResponseBody
    public Response login(){
        //登录认证未通过
        if(!ShiroUtil.isAuthenticated()){
            return ResponseFactory.getResponse(ResponseEnum.please_login);
        }
        return ResponseFactory.getSuccessData(ShiroUtil.getUser());
    }

//    @GetMapping("")
//    public String login(){
//
//        return "login";
//    }


    @PostMapping("")
    @ResponseBody
    public Response fail(HttpServletRequest request, String username, String password) {

    	if(ShiroUtil.isAuthenticated()){
    		return ResponseFactory.getSuccess(null,ShiroUtil.getUser());
		}

		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");

		if ("".equals(username)) {
			return ResponseFactory.getFailure("用户名不能为空，请重新输入");
		} else if ("".equals(password)) {
			return ResponseFactory.getFailure("密码不能为空，请重新输入");
		} else if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			return ResponseFactory.getFailure("用户名或密码错误，请重新输入");
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			return ResponseFactory.getFailure("用户名或密码错误，请重新输入!");
		} else if (DisabledAccountException.class.getName().equals(exceptionClassName)) {
			return ResponseFactory.getFailure("此账户已被禁用");
		} else if (exceptionClassName != null) {
			return ResponseFactory.getFailure(exceptionClassName);
		}

        return ResponseFactory.getFailure();
    }
}
