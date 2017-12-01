package com.divinejicks.schoolmanager.sms.schoolmanagementsms.implementation;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Department;
import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository.DepartmentRepository;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentRepository departmentRepository;

    @Override
    public Page<Department> getAllDepartment(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department getDepartment(Integer id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Page<Department> getName(String name, Pageable pageable) {
        return departmentRepository.findByName(name,pageable);
    }

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department, Integer id) {
        Department oldDepartment = getDepartment(id);

        oldDepartment.setName(department.getName());
        oldDepartment.setFaculty(department.getFaculty());

        return oldDepartment;
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.delete(id);
    }
}
