package com.tts.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * HelloController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11 3, 2016</pre>
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest extends BaseControllerTest {
//    @Autowired
//    private MockMvc mvc;
    /**
     * Method: home(@RequestParam String name, Model model)
     */
    @Test
    public void testHome() throws Exception {
        MockHttpServletResponse msr = doGet("/hello?name=scala");
//        org.springframework.util.Assert.notNull(msr.getContentAsString());
        System.out.println(msr.getContentAsString());
    }

//    @Test
//    public void hiTest() throws Exception{
//        String s = mvc.perform(get("/hi")).andReturn().getResponse().getContentAsString();
//        System.out.println(s);
//    }
    @Test
    public void hiBaseTest() throws Exception{
        MockHttpServletResponse msr = super.doGet("/hi");
        System.out.println(msr.getContentAsString());
    }
}
