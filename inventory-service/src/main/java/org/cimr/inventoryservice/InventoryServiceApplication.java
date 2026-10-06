package org.cimr.inventoryservice;

import org.cimr.inventoryservice.dao.ProductRepository;
import org.cimr.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product(null,"Maxi", "Product 1", 100.00));
            productRepository.save(new Product(null,"Oni", "Product 2", 50.00));
        };
    }

}
