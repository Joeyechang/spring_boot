package com.tts.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mike on 2016/11/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderManagerTest {

    @Autowired
    OrderManager orderManager;

    @Test
    public void testSend(){
        orderManager.send(" Send from JavaMail");
    }
}
