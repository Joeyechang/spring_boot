package ch2.el

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
  * Created by mike on 2016/10/18.
  */
object ELTest {
  def main(args: Array[String]) {
    val context:AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext(new ELConfig().getClass)

  }

}
