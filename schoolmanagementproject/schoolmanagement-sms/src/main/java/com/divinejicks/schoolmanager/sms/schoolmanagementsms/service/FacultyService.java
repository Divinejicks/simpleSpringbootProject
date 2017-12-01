package com.divinejicks.schoolmanager.sms.schoolmanagementsms.service;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacultyService {
    Page<Faculty> getAllFaculty(Pageable pageable);

    Faculty getFaculty(Integer id);

    Page<Faculty> getName(String name, Pageable pageable);

    void addFaculty(Faculty faculty);

    Faculty updateFaculty(Faculty faculty, Integer id);

    void deleteFaculty(Integer id);
}
