package com.bookverse.single_file_monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate; // Yeni import

@SpringBootApplication
public class SingleFileMonolithApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingleFileMonolithApplication.class, args);
	}

	// RestTemplate Bean'ini tanımlıyoruz.
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
