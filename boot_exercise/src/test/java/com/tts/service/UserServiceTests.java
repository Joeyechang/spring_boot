package com.tts.service;

import javax.annotation.Resource;

import com.tts.entiy.User;
import com.tts.service.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Resource
    private UserService userService;

    @Resource
    UserRepository userRepository;

    @Test
    public void findOneTest() {
        Assert.assertEquals("用户名", "test1", userService.findOne(1).getName());
    }

    @Test
    public void findById(){
        Assert.assertEquals("用户名", "test1", userRepository.findById(1).getName());
    }

    @Test
    public void findByNameLikeTest(){
        List<User> list = userRepository.findByNameLike("test");
        list.stream().map(user -> user.getName()).forEach(System.out::println);
        Assert.assertEquals("用户：", 3, list.size());
    }
    @Test
    public void findByNameAndSortTest(){
        List<User> list = userRepository.findByNameAndSort("test", new Sort(Sort.Direction.DESC, "name"));
        list.stream().map(user -> user.getName()).forEach(System.out::println);
    }

    @Test
    public void findOneByNameTest(){
        List<User> list = userRepository.findOneByName("test", new PageRequest(0,1));
        list.stream().map(user -> user.getName()).forEach(System.out::println);
    }
}
