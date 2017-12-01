package com.divinejicks.schoolmanager.sms.schoolmanagementsms.implementation;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Course;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository.CourseRepository;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseRepository courseRepository;
    @Override
    public Page<Course> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course getCourse(Integer id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Page<Course> getName(String name, Pageable pageable) {
        return courseRepository.findByName(name,pageable);
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course, Integer id) {
        Course oldCourse = getCourse(id);

        oldCourse.setName(course.getName());
        oldCourse.setCode(course.getCode());
        oldCourse.setDepartments(course.getDepartments());

        return oldCourse;
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.delete(id);
    }
}
