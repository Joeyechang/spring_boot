package springboot.chapter2.beanScope_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mike on 2016/10/26.
 */
public class DemoRunner {
    private static Logger logger = LoggerFactory.getLogger(DemoRunner.class);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoSingletonService demoSingletonService1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService demoSingletonService2 = context.getBean(DemoSingletonService.class);
        logger.info("s1 与 s2 是否相等:{}", demoSingletonService1.equals(demoSingletonService2));

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
        logger.info("p1 与 p2 是否相等：{}", p1.equals(p2));

        context.close();
    }
}
