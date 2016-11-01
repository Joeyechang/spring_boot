package com.tts.service;

import javax.annotation.Resource;

import com.tts.entiy.User;
import com.tts.service.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class UserServiceTests {

    @Resource
    private UserService userService;

    @Resource
    UserRepository userRepository;

    @Test
    public void findOneTest() {
        Assert.assertEquals("用户名", "leongfeng", userService.findOne(1).getUsername());
    }

    @Test
    public void findById(){
        Assert.assertEquals("用户名", "leongfeng", userRepository.findById(1).getUsername());
    }

    @Test
    public void findByUsrnameTest(){
        User user = userRepository.findByUsername("leongfeng");
        System.out.println(user.toString());
    }
    @Test
    public void findByNameLikeTest(){
        List<User> list = userRepository.findByUsernameLike("l");
        list.stream().map(user -> user.getUsername()).forEach(System.out::println);
        Assert.assertEquals("用户：", 2, list.size());
    }
    @Test
    public void findByNameAndSortTest(){
        List<User> list = userRepository.findByUsernameAndSort("leongfeng", new Sort(Sort.Direction.DESC, "username"));
        list.stream().map(user -> user.getUsername()).forEach(System.out::println);
    }

    @Test
    public void findOneByNameTest(){
        List<User> list = userRepository.findOneByUsername("leongfeng", new PageRequest(0,1));
        list.stream().map(user -> user.getUsername()).forEach(System.out::println);
    }
}
