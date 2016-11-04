package com.tts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author phoenix
 * @since 2016.11.13
 */
public class BaseControllerTest {
	private static ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private MockMvc mvc;
	
	/**
	 * 
	 * @param url should be a whole URL like "/hello?name=test"
	 * @return
	 * @throws Exception
	 */
	public MockHttpServletResponse doGet(String url) throws Exception {
		ResultActions ra = this.mvc.perform(get(url));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doPost(String url, Object params) throws Exception {
		ResultActions ra = this.mvc.perform(
				post(url).content(objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doPatch(String url, Object params) throws Exception {
		ResultActions ra = this.mvc.perform(
				patch(url).content(objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doPut(String url, Object params) throws Exception {
		ResultActions ra = this.mvc
				.perform(put(url, objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doDelete(String url, Object params) throws Exception {
		ResultActions ra = this.mvc
				.perform(delete(url, objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}
	
	public MockHttpServletResponse doFileUpload(String url, MockMultipartFile ... files){
//		ResultActions ra = this.mvc.perform(fileUpload(url).file(file));
		return null;
	}

}
