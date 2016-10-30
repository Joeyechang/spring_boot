package com.tts.controller;

import com.tts.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mike on 2016/10/29.
 */
@RestController
public class RestDemoController {

    @Autowired
    AuthorSettings authorSettings;

    @RequestMapping("/author")
    AuthorSettings author(){
        return authorSettings;
    }
}
