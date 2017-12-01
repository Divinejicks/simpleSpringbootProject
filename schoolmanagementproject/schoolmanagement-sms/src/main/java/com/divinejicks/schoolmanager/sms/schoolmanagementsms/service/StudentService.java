package com.divinejicks.schoolmanager.sms.schoolmanagementsms.service;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudent(Pageable pageable);

    Student getStudent(Integer id);

    Page<Student> getName(String name, Pageable pageable);

    void addStudent(Student student);

    Student updateStudent(Student student, Integer id);

    void deleteStudent(Integer id);
}
