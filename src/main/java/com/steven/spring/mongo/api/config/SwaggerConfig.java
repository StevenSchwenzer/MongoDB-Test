package com.steven.spring.mongo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2
public class SwaggerConfig {
        
        private static final String TITLE = "MongoDB-Test SpringBoot";

        private static final String DESCRIPTION = "Just Testing Microservice with MongoDB";

        private static final String VERSION = "1.0.0";

        @Bean
        public Docket postsApi() {
                return new Docket(DocumentationType.SWAGGER_2)
                        .groupName("public-api")
                        .apiInfo(apiInfo())
                        .select()
                        .paths(postPaths())
                        .build();
        }

        private Predicate<String> postPaths() { return or(regex("api/posts.*"), regex("api/.*"));}

        @SuppressWarnings("deprecation")
        private ApiInfo apiInfo() {
                return new ApiInfoBuilder()
                        .title(TITLE)
                        .description(DESCRIPTION)
                        .version(VERSION)
                        .build();
        }
}
