package org.mdh.pmm.references.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("pmmref")
@ComponentScan(basePackages = "org.mdh.pmm.references.pmmref")
public class PmmRefConfig {
    private static class PersonalPCConfig {
    }

}