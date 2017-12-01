package com.divinejicks.schoolmanager.sms.schoolmanagementsms.service;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    Page<Department> getAllDepartment(Pageable pageable);

    Department getDepartment(Integer id);

    Page<Department> getName(String name, Pageable pageable);

    void addDepartment(Department department);

    Department updateDepartment(Department department, Integer id);

    void deleteDepartment(Integer id);
}
