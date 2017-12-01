package com.divinejicks.schoolmanager.sms.schoolmanagementsms.controller;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Teacher;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * Get all teacher
     * @param pageable
     * @return
     */
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all the teachers", response = Teacher.class)
    public Page<Teacher> getAllTeachers(Pageable pageable){
        return teacherService.getAllTeachers(pageable);
    }

    /**
     * get a particular teacher
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a teacher", response = Teacher.class)
    public Teacher getTeacher(@PathVariable Integer id){
        return teacherService.getTeacher(id);
    }

    /**
     * find by name
     * @param name
     * @param pageable
     * @return
     */
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a teacher(s) by the name", response = Teacher.class)
    public Page<Teacher> getName(@PathVariable String name, Pageable pageable){
        return teacherService.getName(name,pageable);
    }

    /**
     * add a teacher
     * @param teacher
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a new teacher", response = Teacher.class)
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    /**
     * update a teacher
     * @param teacher
     *
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update an existing teacher", response = Teacher.class)
    public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable Integer id){
        return teacherService.updateTeacher(teacher,id);
    }

    /**
     * delete a teacher
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "delete an existing teacher", response = Teacher.class)
    public void deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
    }

}
