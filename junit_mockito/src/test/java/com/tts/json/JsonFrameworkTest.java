package com.tts.json;

import com.tts.entiy.Role;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tts.entiy.User;

import java.util.HashMap;
import java.util.Map;

public class JsonFrameworkTest {
	private final static Logger logger = LoggerFactory.getLogger(JsonFrameworkTest.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();
	Role role;
	@Before
	public void setUp(){
		role = new Role(1, "test");
	}
	
	@Test
	public void objectToStringByFastJsonTest(){
//		logger.info(JSONObject.toJSONString(user));
	}
	
	@Test
	public void objectToStringByJacksonTest() throws JsonProcessingException{

		logger.info(objectMapper.writeValueAsString(role));
	}

	@Test
    public void testMap()throws JsonProcessingException{
        Map<String, String> map = new HashMap<>();
        map.put("some-random", "4");
        logger.info(objectMapper.writeValueAsString(map));
    }
}
