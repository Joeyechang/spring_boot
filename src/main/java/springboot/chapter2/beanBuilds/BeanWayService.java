package springboot.chapter2.beanBuilds;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mike on 2016/10/26.
 */
public class BeanWayService {
    public void init(){
        System.out.println("==============@Bean-init-method=================");
    }

    public BeanWayService(){
        System.out.println("=================初始化构造函数==============");
    }

    public void destroy(){
        System.out.println("============@Bean-destroy-method==========================");
    }
}
