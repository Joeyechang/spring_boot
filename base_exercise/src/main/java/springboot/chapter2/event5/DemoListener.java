package springboot.chapter2.event5;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by mike on 2016/10/28.
 * 2. 事件监听器
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("我接收到了 bean-demoPublisher 发布的消息：" + msg);
    }
}
