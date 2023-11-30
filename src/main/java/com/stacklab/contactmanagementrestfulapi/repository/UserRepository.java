package com.stacklab.contactmanagementrestfulapi.repository;

import com.stacklab.contactmanagementrestfulapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
