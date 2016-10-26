package springboot.chapter2.beanScope;

import org.springframework.stereotype.Service;

/**
 * Created by mike on 2016/10/26.
 */
@Service //默认为Singleton，相当于@Scope("singleton")
public class DemoSingletonService {
}
