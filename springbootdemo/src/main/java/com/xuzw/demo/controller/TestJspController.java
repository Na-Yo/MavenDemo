package com.xuzw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/testJspController")
public class TestJspController {

    @RequestMapping("/testJsp")
    public String testJsp(HttpServletRequest request){
        System.out.println("====testJsp====");
        return "/index";
    }
}
