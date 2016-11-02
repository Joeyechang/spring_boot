package com.tts.service;

import com.tts.entiy.Person;
import com.tts.service.dao.PersonDAO;

/**
 * Created by mike on 2016/11/2.
 */
public class PersonService {
    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public boolean update(Integer personId, String name) {
        Person person = personDAO.fetchPerson(personId);
        if (person != null) {
            Person updatedPerson = new Person(person.getPersonID(), name);
            personDAO.update(updatedPerson);
            return true;
        } else {
            return false;
        }
    }
}
