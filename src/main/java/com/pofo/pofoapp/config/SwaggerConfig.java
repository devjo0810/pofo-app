package com.pofo.pofoapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.pofo.pofoapp.config
 * fileName       : SwaggerConfig
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1-definition")
                .pathsToMatch("/api/**")
                .build();
    }

    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info().title("POFO API")
                        .description("POFO API 명세서입니다.")
                        .version("v0.0.1"));
    }

}
