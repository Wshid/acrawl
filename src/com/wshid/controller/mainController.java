package com.wshid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wshid
 * @project acrawl
 * @date 2018. 3. 18. AM 11:27
 */
@Controller
public class mainController {
    @RequestMapping("/")
    public String index(Model m){
        m.addAttribute("index", "first index");
        return "main";
    }
}
