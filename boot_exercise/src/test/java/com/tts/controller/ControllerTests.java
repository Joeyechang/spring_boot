package com.tts.controller;

import com.tts.entiy.User;
import com.tts.service.dao.UserDAO;
import com.tts.service.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.test.web.servlet.result.*;
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
	public void indexTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON).param("name","scala"))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"));
		//.andExpect(content().string(equalTo("index")));
	}

	@Test
    public void asyncTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/async")).andExpect(status().isOk()).andExpect(content().string("success"));
    }
	
}
