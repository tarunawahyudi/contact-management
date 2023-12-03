package com.stacklab.contactmanagementrestfulapi.repository;

import com.stacklab.contactmanagementrestfulapi.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
