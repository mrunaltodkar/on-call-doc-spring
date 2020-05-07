package com.groupon.grouponeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class GrouponEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrouponEurekaApplication.class, args);
	}

}
