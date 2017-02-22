package com.tts.controller;

import io.swagger.annotations.*;
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

    @ApiOperation(value = "Get a value", notes = "测试GET方法")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@ApiParam(value = "test id", defaultValue = "10086") @PathVariable String id){
        return "Get:" + id;
    }

    @ApiOperation(value = "Add a value", notes = "测试POST方法")
    @ApiImplicitParams({@ApiImplicitParam(value = "description", defaultValue = "10010")})
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String add(@PathVariable String id){
        return "add:" + id;
    }
}
