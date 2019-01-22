package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by WangXinbiao on 2018/12/27
 */
@Controller
@RequestMapping("/public")
public class ThreeAppLoginController {

    @GetMapping("/list1")
    public String list() {
//        return "redirect:list.html";
        return "list";
    }
}
