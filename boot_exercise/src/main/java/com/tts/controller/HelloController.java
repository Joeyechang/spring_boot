package com.tts.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Value("${book.name}")
    String bookName;

    @RequestMapping(value = "/hello")
    String home(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        System.out.println("bookName:" + bookName);
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/async")
    String async(){ return "success";}

}
