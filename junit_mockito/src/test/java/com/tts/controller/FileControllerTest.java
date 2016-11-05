package com.tts.controller;

import com.tts.entiy.Role;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/** 
* FileController Tester. 
* 
* @author <Authors name> 
* @since
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@WebMvcTest(FileController.class)
public class FileControllerTest extends BaseControllerTest{
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.setMvc(MockMvcBuilders.webAppContextSetup(this.context).build());
    }


    /**
    * Method: saveAuto(
     * @RequestPart(value = "json") JsonPojo pojo,
     * @RequestParam(value = "some-random") String random,
     * @RequestParam(value = "data", required = true) MultipartFile file)
    */
    @Test
    public void testSaveAuto() throws Exception {
        MockMultipartFile firstFile = new MockMultipartFile("data", "filename.txt", "text/plain","mock file test".getBytes());
//        FileUtils.writeByteArrayToFile(new File("file.txt"), firstFile.getBytes());
        MockMultipartFile secondFile = new MockMultipartFile("data", "other-file-name.data", "text/plain", "some other type".getBytes());
        MockMultipartFile jsonFile = new MockMultipartFile("json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload").file(firstFile).file(secondFile).file(jsonFile)
                .param("random", "4")).andExpect(status().is(200)).andExpect(content().string("success"));
        System.out.println("=====================");
        files(firstFile, secondFile);
    }

    @Test
    public void testSaveAutoByBase() throws Exception {
        MockMultipartFile firstFile = new MockMultipartFile("data", "filename.txt", "text/plain","mock file test".getBytes());
//        FileUtils.writeByteArrayToFile(new File("file.txt"), firstFile.getBytes());
        MockMultipartFile secondFile = new MockMultipartFile("data", "other-file-name.data", "text/plain", "some other type".getBytes());
        MockMultipartFile jsonFile = new MockMultipartFile("json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
        MockHttpServletResponse msr = doFileUpload("/upload?some-random=4", new Role(1,"test"), firstFile, secondFile, jsonFile);
        System.out.println("result: " + msr.getContentAsString());
    }

    public void files(MockMultipartFile ... files){
        Arrays.stream(files).forEach(file -> System.out.println(file.getOriginalFilename()));
    }
    public MockMvc getMvc() {
        return mockMvc;
    }

    public void setMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
}
