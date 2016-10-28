package com.tts.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session was created.............");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session was destroyed......");
    }
}
