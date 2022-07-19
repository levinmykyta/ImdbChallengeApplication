package com.bibs.imdbChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ImdbChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbChallengeApplication.class, args);
	}

}
