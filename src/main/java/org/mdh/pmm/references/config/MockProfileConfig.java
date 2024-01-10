package org.mdh.pmm.references.config;

import org.mdh.pmm.references.mock.config.OpenAPIConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mock")
@ComponentScan(basePackages = "org.mdh.pmm.references.mock")
public class MockProfileConfig {
    @Import(OpenAPIConfig.class)
    private static class MockConfig {
    }
}
