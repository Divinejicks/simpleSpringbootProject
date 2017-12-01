package com.divinejicks.schoolmanager.sms.schoolmanagementsms.implementation;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Student;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository.StudentRepository;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentRepository studentRepository;
    @Override
    public Page<Student> getAllStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Page<Student> getName(String name, Pageable pageable) {
        return studentRepository.findByName(name,pageable);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Integer id) {
        Student oldStudent = getStudent(id);

        oldStudent.setName(student.getName());
        oldStudent.setGrade(student.getGrade());
        oldStudent.setMatricule(student.getMatricule());
        oldStudent.setLevel(student.getLevel());
        oldStudent.setDepartment(student.getDepartment());

        return oldStudent;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.delete(id);
    }
}
