package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Batch;
import com.jcohy.exam.model.School;
import com.jcohy.exam.respository.BatchRepository;
import com.jcohy.exam.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public List<Batch> findBySchool(School school) {
        return batchRepository.findBySchool(school);
    }

    @Override
    public Page<Batch> findAll(Pageable pageable) {
        return batchRepository.findAll(pageable);
    }

    @Override
    public List<Batch> findAll() {
        return batchRepository.findAll();
    }

    @Override
    public Batch findById(Integer id) {
        return batchRepository.findById(id).get();
    }

    @Override
    public Batch saveOrUpdate(Batch Batch) throws ServiceException {
        return batchRepository.save(Batch);
    }

    @Override
    public boolean checkBatch(String name) {
        return false;
    }

    @Override
    public void delete(Integer id) {
        batchRepository.deleteById(id);
    }
}
