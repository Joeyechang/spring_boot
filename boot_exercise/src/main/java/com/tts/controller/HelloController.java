package com.tts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    String home(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        System.out.println("============== hello ==========");
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/async")
    String async(){ return "success";}
}
