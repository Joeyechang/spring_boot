package com.tts.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mike on 2016/10/29.
 * chpater 6.2.3
 */
@Component
@ConfigurationProperties(locations = {"classpath:config/book.properties"}, prefix = "author")
public class AuthorSettings {
    String name;
    Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
