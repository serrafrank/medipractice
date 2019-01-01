package org.medipractice.pageserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@SpringBootApplication
@RepositoryRestController
public class PageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PageServerApplication.class, args);
	}

}

