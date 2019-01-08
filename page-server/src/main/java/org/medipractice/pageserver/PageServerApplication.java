package org.medipractice.pageserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@SpringBootApplication
@RepositoryRestController
@RefreshScope
@EnableDiscoveryClient
public class PageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PageServerApplication.class, args);
	}

}

