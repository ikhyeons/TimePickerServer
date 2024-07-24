package com.ikhyeons.tp.time_picker_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class TimePickerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimePickerServerApplication.class, args);
	}

}
