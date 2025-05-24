package com.digibusy.EventEverEventService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@ComponentScan
@EnableKafka
public class EventEverEventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventEverEventServiceApplication.class, args);
	}

}
