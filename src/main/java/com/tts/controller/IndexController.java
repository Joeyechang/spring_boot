package com.tts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by phoenix on 2016/10/20.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    String index(Model model){
        model.addAttribute("name", "TestName");
        return "index";
    }
}
