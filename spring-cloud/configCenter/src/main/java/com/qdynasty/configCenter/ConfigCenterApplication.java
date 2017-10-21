/**
 * 
 */
package com.qdynasty.configCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author fei.qin
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigCenterApplication.class, args);
	}
}
