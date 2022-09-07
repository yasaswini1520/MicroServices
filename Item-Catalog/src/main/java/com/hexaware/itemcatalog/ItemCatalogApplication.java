package com.hexaware.itemcatalog;

import java.util.stream.Stream;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

import com.hexaware.itemcatalog.entity.Item;
import com.hexaware.itemcatalog.repository.ItemRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class ItemCatalogApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ItemCatalogApplication.class, args);
	}

}


@Component
class ItemInitializer implements CommandLineRunner{

	private ItemRepository itemRepository;
	
	public ItemInitializer(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		
		Stream.of("PUMA","Addidas","Ferrari","Nike","Reebok")
			.forEach(item -> itemRepository.save(new Item(item)));
		
		itemRepository.findAll().forEach(System.out::println);
	}
	
}