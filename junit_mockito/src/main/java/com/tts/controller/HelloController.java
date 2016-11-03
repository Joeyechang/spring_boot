package com.tts.controller;

import com.tts.service.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    String home(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("name=======" + name);
        return "hello";
    }

    @RequestMapping(value = "/hi")
    @ResponseBody
    String hi(){
        return "hi";
    }
}
