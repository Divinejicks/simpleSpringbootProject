package com.divinejicks.schoolmanager.sms.schoolmanagementsms.implementation;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Teacher;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository.TeacherRepository;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherRepository teacherRepository;

    @Override
    public Page<Teacher> getAllTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Teacher getTeacher(Integer id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public Page<Teacher> getName(String name, Pageable pageable) {
        return teacherRepository.findByName(name, pageable);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    @Transactional
    public Teacher updateTeacher(Teacher teacher, Integer id) {
        Teacher oldTeacher = getTeacher(id);

        oldTeacher.setName(teacher.getName());

        return oldTeacher;
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.delete(id);
    }
}
