package com.tts.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mike
 * @since: 2017/2/21
 */
@RestController
@RequestMapping("/test")
@Api(value = "/test", tags = "Test", description = "Test URIs")
public class TestController {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@ApiParam(value = "id", defaultValue = "10086") @PathVariable String id){
        return "Get:" + id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String add(@ApiParam(value = "id", defaultValue = "10086")@PathVariable String id){
        return "add:" + id;
    }
}
