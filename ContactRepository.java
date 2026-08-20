package com.example.contactsecurity.repository;

import com.example.contactsecurity.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository
        extends JpaRepository<Contact, Long> {
}