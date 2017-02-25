package com.example.controller;

import com.example.Responses;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static javafx.scene.input.KeyCode.T;

/**
 * @author: mike
 * @since: 2017/2/25
 */
@RestController
@Api(value = "/", tags = "Index", description = "Index operation")
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "Welcome to springfox-swagger2markup-demo";
    }
}
