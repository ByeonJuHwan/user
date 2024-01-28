package com.join.user.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Swagger 테스트")
                .version("v1")
                .description("잘못된 부분이나 오류 발생 시 바로 말씀해주세요.")
                .contact(new Contact()
                        .name("byeon")
                        .email("asdcz@naver.com"));
        return new OpenAPI().info(info);
    }
}
