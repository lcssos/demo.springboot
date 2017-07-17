package com.hhmedic.demo.controller;

import com.hhmedic.demo.entity.ShiroUser;
import com.hhmedic.demo.response.Response;
import com.hhmedic.demo.response.ResponseFactory;
import com.hhmedic.demo.util.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lcssos on 2017/1/18.
 */

@RestController
@RequestMapping("/")
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${myapp}")
    private String myapp;

    @GetMapping
    public Response<ShiroUser> index(){
        return ResponseFactory.getSuccess(null,ShiroUtil.getUser());
    }

//    @RequestMapping(value = "index")
//    public String index(){
//        return myapp + " -> 中文乱码 -> index -> 1";
//    }
}
