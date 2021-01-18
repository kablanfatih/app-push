package com.kablanfatih.company.repository;

import com.kablanfatih.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
