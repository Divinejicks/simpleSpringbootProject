package com.divinejicks.schoolmanager.sms.schoolmanagementsms.service;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Page<Teacher> getAllTeachers(Pageable pageable);

    Teacher getTeacher(Integer id);

    Page<Teacher> getName(String name, Pageable pageable);

    void addTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher, Integer id);

    void deleteTeacher(Integer id);
}
