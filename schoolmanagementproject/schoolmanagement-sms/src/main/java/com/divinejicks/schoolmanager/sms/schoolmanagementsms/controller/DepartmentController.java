package com.divinejicks.schoolmanager.sms.schoolmanagementsms.controller;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Department;
import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Get all department
     * @param pageable
     * @return
     */
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all the department", response = Department.class)
    public Page<Department> getAllDepartment(Pageable pageable){
        return departmentService.getAllDepartment(pageable);
    }

    /**
     * get a particular department
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a department", response = Department.class)
    public Department getDepartment(@PathVariable Integer id){
        return departmentService.getDepartment(id);
    }

    /**
     * find by name
     * @param name
     * @param pageable
     * @return
     */
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get department by the name", response = Department.class)
    public Page<Department> getName(@PathVariable String name, Pageable pageable){
        return departmentService.getName(name,pageable);
    }

    /**
     * add a department
     * @param department
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a new department", response = Department.class)
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    /**
     * update a department
     * @param department
     *
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update an existing department", response = Department.class)
    public Department updateDepartment(@RequestBody Department department, @PathVariable Integer id){
        return departmentService.updateDepartment(department,id);
    }

    /**
     * delete a department
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "delete an existing department", response = Department.class)
    public void deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
    }
}
