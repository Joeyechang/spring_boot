package com.tts.service.dao;

import com.tts.entiy.User;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
public interface UserJdbcDAO {
    User findOne(int id);
}
