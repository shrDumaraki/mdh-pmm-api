package org.mdh.pmm.references.mock.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

    @Bean
    @ConditionalOnProperty(value = "spring.profiles.active", havingValue = "mock")
    public OpenAPI baseApi(
            @Value("${app-name}") String title,
            @Value("${app-description}") String description,
            @Value("${app-version}") String version
    ) {
        return new OpenAPI()
                .info(
                        new Info()
                                .title(title)
                                .description(description)
                                .version(version)
                ).addSecurityItem(
                        new SecurityRequirement().addList("jwtBearer"));
    }
}
