package com.tts.controller;


import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Created by : phoenix
 * Create Date: 2016/11/3
 */
public class BaseTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
        this.setMvc(MockMvcBuilders.webAppContextSetup(this.context).build());
    }

    public MockHttpServletResponse doGet(String url) throws Exception {
        ResultActions ra = this.getMvc().perform(get(url));
        return ra.andReturn().getResponse();

    }

    public MockHttpServletResponse doPost(String url, Object params) throws Exception {
        ObjectMapper om = new ObjectMapper();
        ResultActions ra = this.getMvc()
                .perform(post(url).content(om.writeValueAsString(params)).contentType(MediaType
                        .APPLICATION_JSON));
        return ra.andReturn().getResponse();
    }

    public MockHttpServletResponse doPatch(String url, Object params) throws Exception {
        ObjectMapper om = new ObjectMapper();
        ResultActions ra = this.getMvc()
                .perform(patch(url).content(om.writeValueAsString(params)).contentType(MediaType
                        .APPLICATION_JSON));
        return ra.andReturn().getResponse();
    }

    public MockHttpServletResponse doPut(String url, Object params) throws Exception {
        JSONObject jsonObject = new JSONObject();

        ResultActions ra = this.getMvc().perform(put(url, jsonObject.toJSONString(params))
                .contentType(MediaType.APPLICATION_JSON));

        return ra.andReturn().getResponse();
    }

    public MockHttpServletResponse doDelete(String url, Object params) throws Exception {
        JSONObject jsonObject = new JSONObject();

        ResultActions ra = this.getMvc().perform(delete(url, jsonObject.toJSONString(params))
                .contentType(MediaType.APPLICATION_JSON));

        return ra.andReturn().getResponse();
    }

    public MockMvc getMvc() {
        return mvc;
    }

    public void setMvc(MockMvc mvc) {
        this.mvc = mvc;
    }

}
