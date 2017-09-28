package com.qdynasty.rtmService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
public class RtmServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtmServerApplication.class, args);
	}
}
