package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Maps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangXinbiao on 2018/12/27
 */
@Controller
@RequestMapping("/public")
public class ThreeAppLoginController {

    @GetMapping("/list1")
    public String list() {
        return "redirect:/public/main.html";
//        return "list";
    }

    @GetMapping("/")
    public String index(Model m) {
        System.out.println("hello word!");
        Map<String,Object> loginInfo = new HashMap<>();
        loginInfo.put("data","****************");
        m.addAttribute("loginInfo", loginInfo);
        return "index";
    }
}
