package com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Integer>{
    Page<Faculty> findByName(String name, Pageable pageable);
}
