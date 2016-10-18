package ch2.bean.scope

import org.springframework.stereotype.Service

/**
  * Created by mike on 2016/10/17.
  * 默认为@Scope("singleton")
  */
@Service("demoSingletonService")
class DemoSingletonService {

}
