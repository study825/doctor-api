package com.example.doctorapi.repository;

import com.example.doctorapi.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByPasswordAndPhone(String password, Integer phone);
}