package com.tts.controller;

import com.tts.service.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "test")
@WebMvcTest(HelloController.class)
//@ContextConfiguration(classes = ControllerTests.class)
public class ControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public void indexTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON).param("name", "scala"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
        //.andExpect(content().string(equalTo("index")));
    }

    @Test
    public void asyncTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/async")).andExpect(status().isOk()).andExpect(content().string("success"));
    }

}
