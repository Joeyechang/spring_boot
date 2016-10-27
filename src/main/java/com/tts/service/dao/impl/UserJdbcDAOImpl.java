package com.tts.service.dao.impl;

import com.tts.entiy.User;
import com.tts.service.dao.UserJdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
@Repository
public class UserJdbcDAOImpl implements UserJdbcDAO {

    @Resource
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static String findSql = "SELECT id, name FROM users WHERE id = :id";

    @Override
    public User findOne(int id) {
        List list = namedParameterJdbcTemplate.query(findSql, new MapSqlParameterSource().addValue("id", id), BeanPropertyRowMapper.newInstance(User.class));

        return list.size() == 1 ? (User)list.get(0) : null;
    }
}
