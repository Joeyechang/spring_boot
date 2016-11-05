package com.tts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;

/**
 * @author phoenix
 * @since 2016.11.13
 */
public class BaseControllerTest {
	private static ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * 
	 * @param url should be a whole URL like "/hello?name=test"
	 * @return
	 * @throws Exception
	 */
	public MockHttpServletResponse doGet(String url) throws Exception {
		ResultActions ra = this.mockMvc.perform(get(url));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doPost(String url, Object params) throws Exception {
		ResultActions ra = this.mockMvc.perform(
				post(url).content(objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doPatch(String url, Object params) throws Exception {
		ResultActions ra = this.mockMvc.perform(
				patch(url).content(objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doPut(String url, Object params) throws Exception {
		ResultActions ra = this.mockMvc
				.perform(put(url, objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doDelete(String url, Object params) throws Exception {
		ResultActions ra = this.mockMvc
				.perform(delete(url, objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON));
		return ra.andReturn().getResponse();
	}

	public MockHttpServletResponse doFileUpload(String url, Object params ,  MockMultipartFile ... files )  throws Exception{
		MockMultipartHttpServletRequestBuilder builder = fileUpload(url);
		Arrays.asList(files).stream().forEach(builder::file);
		builder.content(objectMapper.writeValueAsString(params)).contentType(MediaType.APPLICATION_JSON);
		ResultActions ra = this.mockMvc.perform(builder);
		return ra.andReturn().getResponse();
	}


}
