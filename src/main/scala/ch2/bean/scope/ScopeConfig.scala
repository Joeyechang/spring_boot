package ch2.bean.scope

import org.springframework.context.annotation.{AnnotationConfigApplicationContext, ComponentScan, Configuration}

/**
  * Created by mike on 2016/10/17.
  */
@Configuration
@ComponentScan(Array("ch2.bean.scope"))
class ScopeConfig {

}
