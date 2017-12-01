package com.divinejicks.schoolmanager.sms.schoolmanagementsms.service;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<Course> getAllCourses(Pageable pageable);

    Course getCourse(Integer id);

    Page<Course> getName(String name, Pageable pageable);

    void addCourse(Course course);

    Course updateCourse(Course course, Integer id);

    void deleteCourse(Integer id);
}
