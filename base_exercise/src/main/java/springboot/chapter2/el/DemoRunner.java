package springboot.chapter2.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by mike on 2016/10/26.
 */
public class DemoRunner {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig config = context.getBean(ElConfig.class);
        config.outputResource();
        context.close();
    }
}
