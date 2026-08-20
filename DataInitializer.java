package com.example.contactsecurity.config;

import com.example.contactsecurity.entity.Contact;
import com.example.contactsecurity.entity.User;
import com.example.contactsecurity.repository.ContactRepository;
import com.example.contactsecurity.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            UserRepository userRepository,
            ContactRepository contactRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository
                    .findByUsername("admin")
                    .isEmpty()) {

                userRepository.save(
                    new User(
                        "admin",
                        passwordEncoder.encode("admin123"),
                        "ADMIN"
                    )
                );
            }

            if (contactRepository.count() == 0) {

                contactRepository.save(
                    new Contact(
                        "Aman Kumar",
                        "aman@example.com",
                        "9876543210",
                        "Interested in the Java Full Stack project."
                    )
                );

                contactRepository.save(
                    new Contact(
                        "Priya Sharma",
                        "priya@example.com",
                        "9123456780",
                        "Please share the project details."
                    )
                );

                contactRepository.save(
                    new Contact(
                        "Rahul Singh",
                        "rahul@example.com",
                        "9988776655",
                        "I would like to contact the admin."
                    )
                );
            }
        };
    }
}