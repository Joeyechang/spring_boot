package springboot.chapter3.aware_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mike on 2016/10/29.
 */
public class AwareRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }
}
