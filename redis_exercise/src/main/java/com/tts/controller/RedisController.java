package com.tts.controller;

import com.tts.dao.PersonDao;
import com.tts.databean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author phoenix
 * @since 2016/12/19
 */

@RestController
public class RedisController {
    @Autowired
    private PersonDao personDao;

    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1", "leongfeng", 32);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/str")
    public String str(){
        return personDao.getString();
    }

    @RequestMapping("/person")
    public Person person(){
        return personDao.getPerson();
    }
}
