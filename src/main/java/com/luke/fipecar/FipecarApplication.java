package com.luke.fipecar;

import com.luke.fipecar.main.Application;
import com.luke.fipecar.service.ApiConsumption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipecarApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipecarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Application app = new Application();
		app.showOptions();
	}
}
