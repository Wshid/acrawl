package com.wshid.controller;

import com.wshid.BO.acrawlBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author wshid
 * @project acrawl
 * @date 2018. 3. 18. AM 11:27
 */
@Controller
public class mainController {

    @Autowired
    private acrawlBO abo;


    @RequestMapping(value = "/main_second", method = RequestMethod.GET)
    public ModelAndView mainPage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("second");
        mv.addObject("Real", "Jade:");
        System.out.println("In Logic" + mv.getViewName());


        mv.addObject("name", "springName");
        mv.addObject("phone", abo.printHelloWorld());

        return mv;
    }


    // view로 지정할경우 이와같이 Model인자를 받아 사용한다.
    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String second(HttpServletRequest request, Model model){

        model.addAttribute("Real", "Time");

        return "second";
    }

    @RequestMapping(value = "third", method = RequestMethod.GET)
    public String third(HttpServletRequest request, Model model){
        model.addAttribute("Real", "Third");
        return "second";
    }
}
