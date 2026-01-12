package org.example.echo.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        String jwt = "JWT";
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt);

        Components components = new Components()
                .addSecuritySchemes(jwt, new SecurityScheme()
                        .name(jwt)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")

                );
        return new OpenAPI()
                .components(components)
                .info(apiInfo())        // ✅ 사용
                .addSecurityItem(securityRequirement);
    }

    private Info apiInfo() {                // ✅ 추가!
        return new Info()
                .title("Shop API")      // {} 대신 실제 이름
                .description("Shop API Swagger UI")
                .version("1.0.0");
    }
}