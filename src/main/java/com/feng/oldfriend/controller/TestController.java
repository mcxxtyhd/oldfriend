package com.feng.oldfriend.controller;


import com.feng.oldfriend.entity.LyjRequirement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/theo")
    public String test(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("theoname","19960922");
        return "123asdasdasdasdasd";
    }


    @RequestMapping("/theo1")
    public String test1(HttpServletRequest request){
        HttpSession session = request.getSession();
        String testS=(String)session.getAttribute("theoname");
        testS+=":previous is the result";
        return testS;
    }

    @RequestMapping("/theo2")
    public Integer test2(@RequestBody List<LyjRequirement> lyjRequirement){
        System.out.println("*****************");
        for(LyjRequirement single:lyjRequirement){
            System.out.println(single.getLyjRequirementName());
        }
        System.out.println("*****************");
        return lyjRequirement.size();
    }
}
