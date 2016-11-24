package com.tts.service.impl;

import com.tts.service.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by mike on 2016/11/24.
 */
@Component
public class SimpleOrderManager implements OrderManager {
    @Autowired
    private MailSender mailSender;


    @Override
    public void send(String msg) {
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom("659.lf@163.com");
        mailMsg.setSubject("leongfeng");
        mailMsg.setTo("mike.leong@easternphoenix.com");
        mailMsg.setText("Dear Sir: \n This is a test message:"  + msg );
        try {
            mailSender.send(mailMsg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
