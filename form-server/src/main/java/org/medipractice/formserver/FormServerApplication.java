package org.medipractice.formserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@SpringBootApplication
@RepositoryRestController
public class FormServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormServerApplication.class, args);
	}

}

