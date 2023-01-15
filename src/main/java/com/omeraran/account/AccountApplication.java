package com.omeraran.account;

import com.omeraran.account.model.Customer;
import com.omeraran.account.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountApplication {

	private static   CustomerRepository repository;

	public AccountApplication(CustomerRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		Customer customer = repository.save(new Customer("","Omer","Aran", new HashSet<>()));
		System.out.println(customer);
	}

}
