package com.tts.entiy;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findById", query = "SELECT u FROM  User u WHERE id = ?1")
public class User {

    @Id
    @GeneratedValue
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
