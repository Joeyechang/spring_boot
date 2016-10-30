package springboot.chapter2.beanBuilds_3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by mike on 2016/10/26.
 */
public class JSR250WayService {
    @PostConstruct
    public void init(){
        System.out.println("-------------jsr250-init-method-----------");
    }
    public JSR250WayService(){
        System.out.println("-------------初始化构造函数--JSR250-----------");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("------------jsr250-destroy-method------------------");
    }
}
