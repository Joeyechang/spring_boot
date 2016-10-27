package com.tts.service.dao;

import org.springframework.data.repository.CrudRepository;

import com.tts.entiy.User;

public interface UserDAO extends CrudRepository<User, Integer> {
	
}
