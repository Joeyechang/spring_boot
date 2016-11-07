package com.tts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tts.entiy.Role;
import com.tts.service.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by mike on 2016/11/5.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MockMvcController.class)
public class MockMvcControllerTest {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception{
        mockMvc.perform(get("/mock/get?method=testGet"))
                .andExpect(status().is(200))
                .andExpect(content().string("success"));
    }

    @Test
    public void testPostByBean() throws Exception{
        mockMvc.perform(post("/mock/postByBean")
                .param("id", "2")
                .param("name", "ROLE_USER")
                .param("method", "postByBean"))
                .andExpect(status().is(200))
                .andExpect(content().string("success"));
    }
    @Test
    public void testPostByJson() throws Exception{
        mockMvc.perform(post("/mock/postByJson")
                .param("method", "getPost")
                .content(objectMapper.writeValueAsString(new Role(2, "ROLE_USER"))).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("success"));
    }

    @Test
    public void testUpload() throws Exception{
        MockMultipartFile jsonFile = new MockMultipartFile("role", "", "application/json","{\"id\":2,\"name\":\"ROLE_USER\"}".getBytes());
        MockMultipartFile file1 = new MockMultipartFile("file", "filename.txt", "text/plain", "content in file1".getBytes());
        MockMultipartFile file2 = new MockMultipartFile("file", "other-file.data", "text/plain", "content in file2".getBytes());
        mockMvc.perform(fileUpload("/mock/upload")
                .file(jsonFile)
                .file(file1).file(file2))
                .andExpect(status().is(200))
                .andExpect(content().string("success"));
    }

    @MockBean
    private RoleRepository roleRepository;
    @Test
    public void testRest()throws Exception{
        given(this.roleRepository.findOne(2)).willReturn(new Role(2, "ROLE_USER"));
        String content = mockMvc.perform(get("/mock/rest/2"))
                .andExpect(status().is(200)).andReturn().getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void testAll() throws Exception{
        given(this.roleRepository.findAll())
                .willReturn(Arrays.asList(new Role(1, "ROLE_ADMIN"), new Role(2, "ROLE_USER")));
        mockMvc.perform(get("/mock/all"))
                .andExpect(status().is(200))
                .andExpect(content().string("success"));
    }
    
    @Test
    public void testHttp() throws Exception{
    	mockMvc.perform(post("/mock/http").with(request -> {
    		request.setRemoteAddr("192.168.0.1");
    		return request;
    	}));
    }
}
