package org.medipractice.datafileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DatafileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatafileServerApplication.class, args);
    }

}

