package com.bm.demo;

import com.bm.demo.service.AccountService;
import com.bm.demo.service.ExceptionTranslationTestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Executes first
	@Bean
	@Order(1)
	public CommandLineRunner runAccountService(AccountService accountService) {
		return args -> {
			System.out.println("\n ---- [1/2] Running Account Service (Propagation & Isolation Test)---");
			accountService.performTransfer();
		};
	}

	// Executes second
	@Bean
	@Order(2)
	public CommandLineRunner runExceptionTest(ExceptionTranslationTestService testService) {
		return args -> {
			System.out.println("\n--- [2/2] Running Exception Translation Test---");
			testService.testExceptionTranslation();
		};
	}
}