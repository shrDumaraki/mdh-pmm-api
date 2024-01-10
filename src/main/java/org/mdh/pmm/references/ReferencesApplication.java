package org.mdh.pmm.references;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReferencesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReferencesApplication.class, args);
    }

}
