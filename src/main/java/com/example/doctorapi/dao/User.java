package com.example.doctorapi.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private Integer phone;
    private Long createdTime;

    public User(Integer phone, String password, Long createdTime) {
        this.phone = phone;
        this.password = password;
        this.createdTime = createdTime;
    }
}
