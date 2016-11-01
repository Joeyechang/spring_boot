package com.tts.controller;

import com.tts.service.UserService;
import com.tts.service.dao.UserDAO;
import com.tts.service.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Value("${book.name}")
    String bookName;

    @Resource
    UserRepository userRepository;

    @RequestMapping(value = "/hello")
    String home(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        logger.info("name: {}", name);

        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/async")
    String async() {
//        logger.info(userRepository.findById(1).toString());
        return "success";
    }

}
