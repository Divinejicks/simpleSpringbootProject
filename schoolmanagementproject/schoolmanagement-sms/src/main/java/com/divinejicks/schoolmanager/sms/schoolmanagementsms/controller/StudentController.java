package com.divinejicks.schoolmanager.sms.schoolmanagementsms.controller;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Student;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    /**
     * Get all Student
     * @param pageable
     * @return
     */
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all the students", response = Student.class)
    public Page<Student> getAllStudent(Pageable pageable){
        return studentService.getAllStudent(pageable);
    }

    /**
     * get a particular student
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a student", response = Student.class)
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudent(id);
    }

    /**
     * find by name
     * @param name
     * @param pageable
     * @return
     */
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a student(s) by the name", response = Student.class)
    public Page<Student> getName(@PathVariable String name, Pageable pageable){
        return studentService.getName(name,pageable);
    }

    /**
     * add a student
     * @param student
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a new student", response = Student.class)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    /**
     * update a student
     * @param student
     *
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update an existing student", response = Student.class)
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id){
        return studentService.updateStudent(student,id);
    }

    /**
     * delete a student
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "delete an existing student", response = Student.class)
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
}
