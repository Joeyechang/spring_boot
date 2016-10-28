package springboot.chapter2.el;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by mike on 2016/10/26.
 */
@Configuration
@ComponentScan("springboot.chapter2.el")
@PropertySource("classpath:springboot/chapter2/el/test.properties")
public class ElConfig {
    private static Logger logger = LoggerFactory.getLogger(ElConfig.class);
    @Value("I Love you")
    String normal;

    @Value("#{systemProperties['os.name']}")
    String osName;

    @Value("#{T(java.lang.Math).random() * 10.0}")
    double randomNum;

    @Value("#{demoService.another}")
    String fromAnother;

    @Value("classpath:springboot/chapter2/el/test.txt")
    Resource testFile;

    @Value("http://www.baidu.com")
    Resource testUrl;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() throws IOException {
        logger.info("normal: {}", normal);
        logger.info("osName: {}", osName);
        logger.info("randomNum: {}", randomNum);
        logger.info("fromAnother: {}", fromAnother);
        logger.info("testFile:\n {}", IOUtils.toString(testFile.getInputStream()));
        logger.info("testUrl:\n {}", IOUtils.toString(testUrl.getInputStream()));
        logger.info("Environment: {}", environment.getProperty("book.name"));
    }
}
