package com.tts.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
@RestController
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String home(@RequestParam String name){
        return "Hello " + name;
    }
}
