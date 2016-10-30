package springboot.chapter3.schedule_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mike on 2016/10/29.
 */
public class ScheduleRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfig.class);
//        context.getBean(ScheduledTaskService.class);
//        context.close();
    }
}
