/**
 * 
 */
package com.qdynasty.monitorCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * @author fei.qin
 *
 */
@SpringBootApplication
@EnableTurbineStream
@EnableDiscoveryClient
@EnableAdminServer
public class MonitorCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonitorCenterApplication.class, args);
	}
}
