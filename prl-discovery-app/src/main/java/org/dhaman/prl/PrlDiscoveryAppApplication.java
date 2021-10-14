package org.dhaman.prl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PrlDiscoveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrlDiscoveryAppApplication.class, args);
	}

}
