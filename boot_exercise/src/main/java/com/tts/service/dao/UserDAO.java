package com.tts.service.dao;

import com.tts.entiy.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {
	
}
