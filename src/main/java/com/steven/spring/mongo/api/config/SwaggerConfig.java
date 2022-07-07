package com.steven.spring.mongo.api.config;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

        private static final String TITLE = "Booking-Microservice API";
        private static final String DESCRIPTION = "Microservice for determining bookings in the context "
                + "of an ending charging request";
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

        private Predicate<String> postPaths() {
                return or(regex("/api/posts.*"), regex("/api/.*"));
        }



        @SuppressWarnings("deprecation")
        private ApiInfo apiInfo() {
                return new ApiInfoBuilder()
                        .title(TITLE)
                        .description(DESCRIPTION)
                        //.termsOfServiceUrl("https://www.my-oli.com/en/")
                        //.contact("maurizio.bono@my-oli.com")
                        //.license("OLI Systems License")
                        //.licenseUrl("muhammad.yahya@my-oli.com")
                        .version(VERSION)
                        .build();
        }
}
