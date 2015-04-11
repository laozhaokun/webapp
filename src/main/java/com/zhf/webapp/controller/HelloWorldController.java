package com.zhf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhaohf on 2015/4/4.
 */

@Controller
//@RequestMapping("/hellomvc")
public class HelloWorldController {
    @RequestMapping({"/hello","/"})
    public String hello(@RequestParam("name") String name, Model model) {
        System.out.print("Hello , " + name);
        model.addAttribute("name", name);
        return "hello";
    }

}

