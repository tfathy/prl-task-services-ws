package org.dhaman.prl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PrlTasksAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrlTasksAppApplication.class, args);
	}

}
