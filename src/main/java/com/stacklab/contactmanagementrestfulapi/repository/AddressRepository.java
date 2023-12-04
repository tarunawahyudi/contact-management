package com.stacklab.contactmanagementrestfulapi.repository;

import com.stacklab.contactmanagementrestfulapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
