package com.samir.medivault;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class MediVaultApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MediVaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
