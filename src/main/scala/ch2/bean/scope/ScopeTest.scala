package ch2.bean.scope

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
  * Created by mike on 2016/10/17.
  */
object ScopeTest {
  def main(args: Array[String]) {
    val scopeConfig = new ScopeConfig
    val context: AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext(scopeConfig.getClass)
    val s1: AnyRef = context.getBean(new DemoSingletonService().getClass)
    val s2: AnyRef = context.getBean("demoSingletonService")
    val p2:AnyRef = context.getBean(new DemoPrototypeService().getClass)
    val p1:AnyRef = context.getBean("demoPrototypeService")
    println("s1 is equals s2:" + s1.eq(s2))
    println("p1 is equals p2:" + p1.eq(p2))
  }
}
