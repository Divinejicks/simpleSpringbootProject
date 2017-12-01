package com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Page<Teacher> findByName(String name, Pageable pageable);
}
