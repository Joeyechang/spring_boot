package ch2.bean.scope

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

/**
  * Created by mike on 2016/10/17.
  */
@Service
@Scope("prototype")
class DemoPrototypeService {

}
