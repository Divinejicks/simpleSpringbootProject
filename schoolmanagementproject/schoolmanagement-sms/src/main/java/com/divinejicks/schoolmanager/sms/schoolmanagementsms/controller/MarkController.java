package com.divinejicks.schoolmanager.sms.schoolmanagementsms.controller;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Mark;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.MarkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marks")
public class MarkController {
    private MarkService markService;

    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }
    /**
     * Get all mark
     * @param pageable
     * @return
     */
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get all the mark", response = Mark.class)
    public Page<Mark> getAllMarks(Pageable pageable){
        return markService.getAllMarks(pageable);
    }

    /**
     * get a particular mark
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get a mark", response = Mark.class)
    public Mark getMark(@PathVariable Integer id){
        return markService.getMark(id);
    }

    /**
     * add a mark
     * @param mark
     */
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a new mark", response = Mark.class)
    public void addMark(@RequestBody Mark mark){
        markService.addMark(mark);
    }

    /**
     * update a mark
     * @param mark
     *
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update an existing mark", response = Mark.class)
    public Mark updateMark(@RequestBody Mark mark, @PathVariable Integer id){
        return markService.updateMark(mark,id);
    }

    /**
     * delete a mark
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "delete an existing mark", response = Mark.class)
    public void deleteMark(@PathVariable Integer id){
        markService.deleteMark(id);
    }
}
