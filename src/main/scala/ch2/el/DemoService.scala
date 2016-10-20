package ch2.el

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import scala.beans.BeanProperty

/**
  * Created by mike on 2016/10/18.
  */
@Service
class DemoService {
  @Value("properties of other Class")
  @BeanProperty
  var another:String = null
}
