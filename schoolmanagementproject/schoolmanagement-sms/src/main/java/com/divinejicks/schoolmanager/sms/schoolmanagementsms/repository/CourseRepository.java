package com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CourseRepository extends JpaRepository<Course,Integer> {
    Page<Course> findByName(String name, Pageable pageable);
}
