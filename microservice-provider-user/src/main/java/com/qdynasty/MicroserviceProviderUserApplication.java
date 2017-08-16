package com.qdynasty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient 也可以使用 @EnableEurekaClient 代替；
 * @EnableDiscoveryClient 为各种服务组件都提供的支持，是一个高度抽象。
 * @EnableEurekaClient 是Eureka的实现，只能和Eureka配合使用。
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderUserApplication.class, args);
	}
}
