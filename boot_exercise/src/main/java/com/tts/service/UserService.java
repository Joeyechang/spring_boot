package com.tts.service;

import com.tts.entiy.User;
import com.tts.service.dao.UserDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserService {
	@Resource
	private UserDAO userDAO;
	
	@Transactional
	public void save(User user){
		userDAO.save(user);
	}
	
	public User findOne(int id){
		User user = userDAO.findOne(1);
		return userDAO.findOne(id);
	}
	
}
