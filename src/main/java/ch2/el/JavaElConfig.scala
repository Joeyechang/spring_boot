package ch2.el

import javax.annotation.Resource

import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration, PropertySource}
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.env.Environment

/**
  * Created by mike on 2016/10/18.
  */
@Configuration
@ComponentScan(Array("ch2.el"))
@PropertySource(Array("classpath:ch2/el/test.properties"))
class JavaElConfig {

  @Value("I love you so much!")
  var normal:String =""

  @Value("#{systemProperties['os.name']}")
  var osName:String = ""

  @Value("#{T(java.lang.Math).random() * 100.0}")
  var randomNum:Double = 0.0

//  @Value("#{demoService.another}")
  // error
  var another:String = ""

//  @Value("classpath:ch2\\el\\test.txt")
  // error
  var testTxt:Resource = null

  @Value("${book.name}")
  var bookName:String = ""

  @Autowired
  var environment:Environment = null

  @Bean
  var propertyConfigure:PropertySourcesPlaceholderConfigurer = null

  override def toString = s"ElConfig("+osName + ", " + randomNum + ", " + bookName+ ", "+ environment.getProperty("book.author")+")"
}
