package com.example.doctorapi.repository;

import com.example.doctorapi.dao.PhoneLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneLogRepository extends JpaRepository<PhoneLog, Long> {
}
