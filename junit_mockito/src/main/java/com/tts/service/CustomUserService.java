package com.tts.service;

import com.tts.entiy.User;
import com.tts.service.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

/**
 * Created by mike on 2016/10/31.
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user))
            throw new UsernameNotFoundException("用户名不存在");
        user.getRoles().forEach(System.out::println);
        return user;
    }
}
