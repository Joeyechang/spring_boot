package com.tts.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
@Component
@Order(value = 1)
public class MyCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("<<<<<<<<<<<<<<<<<<<< MyCommandLineRunner2 服务启动执行，执行加载数据等操作>>>>>>>>>>>>>>>>");
    }
}
