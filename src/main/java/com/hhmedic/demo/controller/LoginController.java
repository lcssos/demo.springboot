package com.hhmedic.demo.controller;

import com.hhmedic.demo.entity.ShiroUser;
import com.hhmedic.demo.response.Response;
import com.hhmedic.demo.response.ResponseEnum;
import com.hhmedic.demo.response.ResponseFactory;
import com.hhmedic.demo.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public Response fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        return ResponseFactory.getFailure();
    }
}
