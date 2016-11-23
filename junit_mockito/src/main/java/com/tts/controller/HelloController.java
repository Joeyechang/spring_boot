package com.tts.controller;

import com.tts.entiy.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    String home(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("name=======" + name);
        return "hello";
    }

    @RequestMapping(value = "/hi")
    String hi(){
        return "hi";
    }

    @RequestMapping(value = "/testPost", method = RequestMethod.POST)
    String post(Role role){
        logger.info("role: {}", role.toString());
        return "success";
    }
}
