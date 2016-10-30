package springboot.chapter3.schedule_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mike on 2016/10/29.
 */
@Configuration
@ComponentScan("springboot.chapter3.schedule_3")
@EnableScheduling
public class SchedulerConfig  {
}
