package com.tts.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
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
