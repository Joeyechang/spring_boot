package com.tts.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by : phoenix
 * Create Date: 2016/10/27
 */
@Configuration
public class MyEnvironment implements EnvironmentAware {

    @Value("${spring.datasource.url}")
    String dataSourceUrl;

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("DataSourceURL: " + dataSourceUrl);
        System.out.println("JAVA_HOME: " + environment.getProperty("JAVA_HOME"));
        // 获取properties文件的属性
        System.out.println("server.port: " + environment.getProperty("server.port"));

        //获取到前缀是"spring.datasource." 的属性列表值.
        RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        System.out.println( "DataSource.username: " + resolver.getProperty("username"));
    }
}
