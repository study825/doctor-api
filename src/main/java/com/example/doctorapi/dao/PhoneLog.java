package com.example.doctorapi.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class PhoneLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long phone;
    private Integer code;
    private Integer status;
    private Long createdTime;

    public PhoneLog(Long phone, Integer code, Integer status, Long createdTime) {
        this.phone = phone;
        this.code = code;
        this.status = status;
        this.createdTime = createdTime;
    }
}
