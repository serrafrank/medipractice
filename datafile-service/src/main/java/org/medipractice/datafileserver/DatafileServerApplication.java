package org.medipractice.datafileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@RefreshScope
@EnableDiscoveryClient
public class DatafileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatafileServerApplication.class, args);
    }

}

