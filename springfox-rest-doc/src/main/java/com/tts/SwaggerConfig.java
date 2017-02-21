package com.tts;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.ant;

/**
 * @author: mike
 * @since: 2017/2/21
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket feedApi() {

        return new Docket(DocumentationType.SWAGGER_2)
            //				.securitySchemes(newArrayList(new BasicAuth("test")))
            .apiInfo(feedApiInfo())
            //				.groupName("feed-process-api")
            .select()
            //				.paths(PathSelectors.regex("/feed.*"))
            .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error"))))
            .build()
            .ignoredParameterTypes(ApiIgnore.class)
            .enableUrlTemplating(true);
    }

    private ApiInfo feedApiInfo() {
        StringBuilder sb = new StringBuilder("关于 **FeedFile** 从下载到导入数据库的整个过程，步骤：").append("\r\n");
        sb.append("1. **download**：下载指定日期的 `FeedFile`；").append("\r\n");
        sb.append("2. **copy**：将指定日期的 `FeedFile` 复制到数据库服务器；").append("\r\n");
        sb.append("3. **import**：将指定日期的 `FeedFile` 导入数据库；").append("\r\n");
        sb.append("4. **assign**：按指定日期分配用户数据；").append("\r\n");
        sb.append("5. **apply**：将当日的数据从 `FeedFile` 数据库同步到 `CentralSecurity` 数据库。").append("\r\n");
        return new ApiInfoBuilder().title("FeedFile process API").description(sb.toString()).version("1.0").build();
    }
}
