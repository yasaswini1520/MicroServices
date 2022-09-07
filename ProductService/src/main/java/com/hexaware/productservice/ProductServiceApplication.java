package com.hexaware.productservice;

import java.util.stream.Stream;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.hexaware.productservice.entity.Product;
import com.hexaware.productservice.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}

@Component
class ProductInitializer implements CommandLineRunner{

	private ProductRepository productRepository;
	
	public ProductInitializer(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		
		Stream.of("Potato","Tomato","Carrot","Beetroot","Mirchi")
			.forEach(product -> productRepository.save(new Product(product)));
		
		productRepository.findAll().forEach(System.out::println);
	}
	
}