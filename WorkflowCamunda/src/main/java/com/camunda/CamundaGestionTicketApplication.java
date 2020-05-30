package com.camunda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class CamundaGestionTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaGestionTicketApplication.class, args);
	}
	
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
       	

}
