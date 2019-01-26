package org.medipractice.pageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@RepositoryRestController
@RefreshScope
@EnableDiscoveryClient
@EnableResourceServer
public class PageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PageServiceApplication.class, args);
	}

}

