package springboot.chapter3.aware_1;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by mike on 2016/10/29.
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    String beanName;
    ResourceLoader resourceLoader;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String getBeanName() {
        return beanName;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
    public void outputResult(){
        System.out.println("Bean 的名称为：" + beanName);
        Resource resource = resourceLoader.getResource("classpath:springboot/chapter2/el_2/test.txt");
        try {
            System.out.println("ResourceLoader 加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
