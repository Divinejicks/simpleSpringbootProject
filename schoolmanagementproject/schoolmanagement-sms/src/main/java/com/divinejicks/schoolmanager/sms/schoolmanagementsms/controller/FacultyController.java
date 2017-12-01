package com.divinejicks.schoolmanager.sms.schoolmanagementsms.controller;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.FacultyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    /**
     * Get all faculty
     * @param pageable
     * @return
     */
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all the faculties", response = Faculty.class)
    public Page<Faculty> getAllFaculty(Pageable pageable){
        return facultyService.getAllFaculty(pageable);
    }

    /**
     * get a particular faculty
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a faculty", response = Faculty.class)
    public Faculty getFaculty(@PathVariable Integer id){
        return facultyService.getFaculty(id);
    }

    /**
     * find by name
     * @param name
     * @param pageable
     * @return
     */
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get faculty by the name", response = Faculty.class)
    public Page<Faculty> getName(@PathVariable String name, Pageable pageable){
        return facultyService.getName(name,pageable);
    }

    /**
     * add a faculty
     * @param faculty
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a new faculty", response = Faculty.class)
    public void addFaculty(@RequestBody Faculty faculty){
        facultyService.addFaculty(faculty);
    }

    /**
     * update a faculty
     * @param faculty
     *
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update an existing faculty", response = Faculty.class)
    public Faculty updateFaculty(@RequestBody Faculty faculty, @PathVariable Integer id){
        return facultyService.updateFaculty(faculty,id);
    }

    /**
     * delete a faculty
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "delete an existing teacher", response = Faculty.class)
    public void deleteFaculty(@PathVariable Integer id){
        facultyService.deleteFaculty(id);
    }
}
