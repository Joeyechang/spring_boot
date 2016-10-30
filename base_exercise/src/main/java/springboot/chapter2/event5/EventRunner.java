package springboot.chapter2.event5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mike on 2016/10/28.
 */
public class EventRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.publish("Event Public Example!!");
        context.close();
    }
}
