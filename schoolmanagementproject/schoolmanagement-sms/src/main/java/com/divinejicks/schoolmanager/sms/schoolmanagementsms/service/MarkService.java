package com.divinejicks.schoolmanager.sms.schoolmanagementsms.service;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarkService {
    Page<Mark> getAllMarks(Pageable pageable);

    Mark getMark(Integer id);

    void addMark(Mark mark);

    Mark updateMark(Mark mark, Integer id);

    void deleteMark(Integer id);
}
