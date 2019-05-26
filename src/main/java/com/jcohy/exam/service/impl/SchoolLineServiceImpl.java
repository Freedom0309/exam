package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.SchoolLine;
import com.jcohy.exam.respository.SchoolLineRepository;
import com.jcohy.exam.service.SchoolLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolLineServiceImpl implements SchoolLineService {

    @Autowired
    private SchoolLineRepository schoolLineRepository;

    @Override
    public Page<SchoolLine> findAll(Pageable pageable) {
        return schoolLineRepository.findAll(pageable);
    }

    @Override
    public long count() {
        return schoolLineRepository.count();
    }

    @Override
    public List<SchoolLine> findAll() {
        return schoolLineRepository.findAll();
    }

    @Override
    public List<Object[]> findAllSchoolLine(Integer page, Integer size) {
        return schoolLineRepository.findAllSchoolLine(page, size);
    }
    @Override
    public SchoolLine findById(Integer id) {
        return schoolLineRepository.findById(id).get();
    }

    @Override
    public SchoolLine saveOrUpdate(SchoolLine schoolLine) throws ServiceException {
        return schoolLineRepository.save(schoolLine);
    }

    @Override
    public void delete(Integer id) {
        schoolLineRepository.deleteById(id);
    }
}
