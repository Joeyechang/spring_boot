package springboot.chapter3.schedule_3;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mike on 2016/10/29.
 */
@Service
public class ScheduledTaskService {
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 5000) //1
    public void reportCurrentTime(){
        System.out.println("每5秒执行一次： " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 45 10 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + " 执行");
    }
}
