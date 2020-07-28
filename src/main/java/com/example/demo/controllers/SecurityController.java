package com.example.demo.controllers;

import com.example.demo.domain.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WangXinbiao on 2019/02/13
 */
@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String userLogin(){

        return "demo-sign";
    }

    @RequestMapping("/login-error")
    public String loginError(){
        return "login-error";
    }

    @ResponseBody
    @RequestMapping("/whoim")
    public UserInfo whoIm(){
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userInfo.getUsername() + " " +userInfo.getPassword());
        return userInfo;
    }
}
