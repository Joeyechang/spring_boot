package springboot.chapter3.multiThread_2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by mike on 2016/10/29.
 */
@Service
public class AsyncTaskService {

    @Async // 表明该方法是个异步方法，如果注解在类级别，则表明该类所有的方法都是异步方法
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务: " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1: " + i);
    }
}
