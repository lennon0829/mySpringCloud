package com.qdynasty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient 也可以使用 @EnableEurekaClient 代替；
 * @EnableDiscoveryClient 为各种服务组件都提供的支持，是一个高度抽象。
 * @EnableEurekaClient 是Eureka的实现，只能和Eureka配合使用。
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroserviceConsumerMovieApplication {

	private RestTemplate restTemplate;

	// 整合Ribbon能力
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		restTemplate = new RestTemplate();

		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieApplication.class, args);
	}
}
