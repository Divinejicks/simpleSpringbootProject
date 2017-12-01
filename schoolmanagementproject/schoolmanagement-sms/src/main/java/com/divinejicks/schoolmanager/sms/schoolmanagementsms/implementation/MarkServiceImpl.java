package com.divinejicks.schoolmanager.sms.schoolmanagementsms.implementation;

import com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao.Mark;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.repository.MarkRepository;
import com.divinejicks.schoolmanager.sms.schoolmanagementsms.service.MarkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MarkServiceImpl implements MarkService {
    @Resource
    private MarkRepository markRepository;

    @Override
    public Page<Mark> getAllMarks(Pageable pageable) {
        return markRepository.findAll(pageable);
    }

    @Override
    public Mark getMark(Integer id) {
        return markRepository.findOne(id);
    }

    @Override
    public void addMark(Mark mark) {
        markRepository.save(mark);
    }

    @Override
    public Mark updateMark(Mark mark, Integer id) {
        Mark oldMark = getMark(id);

        oldMark.setCa_mark(mark.getCa_mark());
        oldMark.setExam_mark(mark.getExam_mark());
        oldMark.setTotal_mark(mark.getTotal_mark());
        oldMark.setCourse(mark.getCourse());

        return oldMark;
    }

    @Override
    public void deleteMark(Integer id) {
        markRepository.delete(id);
    }
}
