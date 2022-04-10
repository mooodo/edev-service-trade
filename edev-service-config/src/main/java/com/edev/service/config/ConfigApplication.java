/* 
 * Created by 2019年2月14日
 */
package com.edev.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The application for the config server.
 * @author fangang
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {

	/**
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
