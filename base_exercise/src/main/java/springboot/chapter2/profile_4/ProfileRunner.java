package springboot.chapter2.profile_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mike on 2016/10/28.
 */
public class ProfileRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 将活动设置为 prod
        context.getEnvironment().setActiveProfiles("prod");
        // 注册
        context.register(ProfileConfig.class);
        // 刷新
        context.refresh();
        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}
