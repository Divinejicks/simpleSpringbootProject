package com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Page<Student> findByName(String name, Pageable pageable);
}
