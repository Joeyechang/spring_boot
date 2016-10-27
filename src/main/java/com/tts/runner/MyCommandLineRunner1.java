package com.tts.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
@Component
@Order(value = 2)
public class MyCommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //args 是程序启动时设置的
        System.out.println(Arrays.asList(args));
        System.out.println(">>>>>>>>>>>>>>>MyCommandLineRunner1 服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
    }
}
