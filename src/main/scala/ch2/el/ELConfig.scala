package ch2.el

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{ComponentScan, Configuration}

import scala.beans.BeanProperty

/**
  * Created by mike on 2016/10/18.
  */
@Configuration
@ComponentScan(Array("ch2.el"))
class ELConfig {

  @Value("I love you so much!")
  var nomar:String ="";

}
