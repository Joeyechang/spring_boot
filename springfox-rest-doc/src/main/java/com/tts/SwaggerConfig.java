package com.tts;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
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
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error"))))
            .build()
            .ignoredParameterTypes(ApiIgnore.class)
            .enableUrlTemplating(true);
    }

    private ApiInfo apiInfo() {
        StringBuilder sb = new StringBuilder("使用 SprinFox + Swagger2Markup 生成API文档：").append("\r\n");
        sb.append("1. **Test**：我新增的 Controller；").append("\r\n");
        sb.append("2. 其他的 Controller 是 Swagger2Markup 官方例子；").append("\r\n");
        return new ApiInfoBuilder().title("REST demo APIs").description(sb.toString()).version("1.0").build();
    }

    /*@Bean
    public Docket petApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("Pet APIs").build())
                .groupName("Pet")
                .select()
                .paths(PathSelectors.regex("/pets.*"))
                .build();
    }*/
}
