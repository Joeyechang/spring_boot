package springboot.chapter3.multiThread_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mike on 2016/10/29.
 */
public class TaskExecutorRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService service = context.getBean(AsyncTaskService.class);
        for (int i= 0; i< 10; i++){
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
        System.out.println("================");
        context.close();
    }
}
