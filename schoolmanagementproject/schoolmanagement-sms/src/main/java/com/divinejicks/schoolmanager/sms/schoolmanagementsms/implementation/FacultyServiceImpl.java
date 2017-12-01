package com.divinejicks.schoolmanager.sms.schoolmanagementsms.implementation;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Faculty;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository.FacultyRepository;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.FacultyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Resource
    private FacultyRepository facultyRepository;

    @Override
    public Page<Faculty> getAllFaculty(Pageable pageable) {
        return facultyRepository.findAll(pageable);
    }

    @Override
    public Faculty getFaculty(Integer id) {
        return facultyRepository.findOne(id);
    }

    @Override
    public Page<Faculty> getName(String name, Pageable pageable) {
        return facultyRepository.findByName(name,pageable);
    }

    @Override
    public void addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    @Transactional
    public Faculty updateFaculty(Faculty faculty, Integer id) {
        Faculty oldFaculty = getFaculty(id);

        oldFaculty.setName(faculty.getName());
        return oldFaculty;
    }

    @Override
    public void deleteFaculty(Integer id) {
        facultyRepository.delete(id);
    }
}
