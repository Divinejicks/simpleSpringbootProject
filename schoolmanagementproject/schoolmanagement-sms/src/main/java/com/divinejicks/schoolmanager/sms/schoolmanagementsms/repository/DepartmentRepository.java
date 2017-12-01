package com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Page<Department> findByName(String name, Pageable pageable);
}
