package ru.ignatovichanastasiia.alfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "ru.ignatovichanastasiia.alfa.feignutill")
public class AlfaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlfaApplication.class, args);
	}
}
