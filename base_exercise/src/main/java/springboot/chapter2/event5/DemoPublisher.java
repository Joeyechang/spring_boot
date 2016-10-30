package springboot.chapter2.event5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by mike on 2016/10/28.
 */
@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext applicationContext; // 用来发布事件
    public void publish(String msg){
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
