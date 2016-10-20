package ch2.el

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
  * Created by mike on 2016/10/18.
  */
object ElTest {
  def main(args: Array[String]) {
    val context:AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext(new ElConfig().getClass)
    val elConfig:ElConfig = context.getBean(new ElConfig().getClass)
    println(elConfig.toString)
    val demoService:DemoService = context.getBean(new DemoService().getClass)
    println(demoService.another)
  }

}
