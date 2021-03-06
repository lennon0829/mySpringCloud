package org.zipkinServer;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

	@Bean
	public MySQLStorage mySQLStorage(DataSource datasource) {
		return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
	}
}
