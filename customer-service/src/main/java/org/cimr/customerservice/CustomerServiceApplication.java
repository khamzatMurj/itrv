package org.cimr.customerservice;

import org.cimr.customerservice.dao.CustomerRepository;
import org.cimr.customerservice.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null, "Hamza", "Mousrij", "hmousrij1@gmail.com"));
            customerRepository.save(new Customer(null, "Denis", "Mousrij", "hmousrij1@gmail.com"));
            customerRepository.save(new Customer(null, "Marchall", "Mousrij", "hmousrij1@gmail.com"));
        };
    }

}
