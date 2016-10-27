package com.tts.service;

import javax.annotation.Resource;

import com.tts.entiy.User;
import com.tts.service.dao.UserJdbcDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Resource
	private UserService userService;
	@Resource
	private UserJdbcDAO userJdbcDAO;
	@Test
	public void findOneTest(){
		Assert.assertEquals("用户名","test3", userService.findOne(3).getName());
	}

	@Test
	public void findOneJdbcTest(){
		User user = userJdbcDAO.findOne(3);
        Assert.assertEquals("用户名","test3", userService.findOne(3).getName());
	}
}
