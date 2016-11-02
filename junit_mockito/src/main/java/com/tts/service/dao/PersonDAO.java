package com.tts.service.dao;

import com.tts.entiy.Person;

/**
 * Created by mike on 2016/11/2.
 */
public interface PersonDAO {
    public Person fetchPerson(Integer personID);

    public void update(Person person);
}