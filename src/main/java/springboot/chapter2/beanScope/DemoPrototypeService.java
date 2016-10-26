package springboot.chapter2.beanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by mike on 2016/10/26.
 */
@Service
@Scope("prototype") //声明为 Prototype
public class DemoPrototypeService {
}
