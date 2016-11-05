package com.tts.entiy;

import javax.persistence.Entity;

/**
 * Created by mike on 2016/11/2.
 */

public class Person {
    private Integer personID;
    private String personName;

    public Person(){

    }

    public Person(Integer personID, String personName) {
        this.personID = personID;
        this.personName = personName;
    }

    public Integer getPersonID() {
        return personID;
    }

    public String getPersonName() {
        return personName;
    }
}