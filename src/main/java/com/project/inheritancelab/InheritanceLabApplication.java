package com.project.inheritancelab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InheritanceLabApplication {

    @Bean
    CommandLineRunner lab(UserRepository userRepo) {
        return args -> {
            Customer customer = new Customer();
            customer.setEmail("asha@shopnest.com");
            customer.setMobileNumber("23454");
            customer.setName("asha");
            userRepo.save(customer);

            Seller seller = new Seller();
            seller.setEmail("ravi@shopnest.com");
            seller.setGstNumber("FSD4334");
            seller.setName("ravi");
            userRepo.save(seller);

            userRepo.findAll().forEach(user -> System.out.println(user.getClass().getSimpleName() + ": " + user.getEmail()));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(InheritanceLabApplication.class, args);
    }

}
