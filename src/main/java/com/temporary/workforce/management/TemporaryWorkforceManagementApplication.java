package com.temporary.workforce.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.temporary.workforce.management.*"})
@EnableSwagger2
public class TemporaryWorkforceManagementApplication{
	public static void main(String[] args) {
		SpringApplication.run(TemporaryWorkforceManagementApplication.class, args);


	}


}
