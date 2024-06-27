package com.samir.medivault;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediVaultApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MediVaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
