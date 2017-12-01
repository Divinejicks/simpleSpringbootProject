package com.divinejicks.schoolmanager.sms.schoolmanagementsms.controller;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Course;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    /**
     * Get all courses
     * @param pageable
     * @return
     */
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all the course", response = Course.class)
    public Page<Course> getAllCourses(Pageable pageable){
        return courseService.getAllCourses(pageable);
    }

    /**
     * get a particular course
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a course", response = Course.class)
    public Course getCourse(@PathVariable Integer id){
        return courseService.getCourse(id);
    }

    /**
     * find by name
     * @param name
     * @param pageable
     * @return
     */
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a course by the name", response = Course.class)
    public Page<Course> getName(@PathVariable String name, Pageable pageable){
        return courseService.getName(name,pageable);
    }

    /**
     * add a course
     * @param course
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a new course", response = Course.class)
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    /**
     * update a course
     * @param course
     *
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update an existing course", response = Course.class)
    public Course updateCourse(@RequestBody Course course, @PathVariable Integer id){
        return courseService.updateCourse(course,id);
    }

    /**
     * delete a course
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "delete an existing course", response = Course.class)
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
