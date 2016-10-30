package springboot.chapter2.event5;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;

/**
 * Created by mike on 2016/10/28.
 * 1. 自定义事件
 */
public class DemoEvent extends ApplicationEvent {
    String msg;
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
