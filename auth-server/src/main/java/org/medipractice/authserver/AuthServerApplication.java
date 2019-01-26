package org.medipractice.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableConfigurationProperties
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
@RefreshScope
@EnableDiscoveryClient
public class AuthServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}