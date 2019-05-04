package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Scoreline;
import com.jcohy.exam.respository.ScorelineRepository;
import com.jcohy.exam.service.ScorelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScorelineServiceImpl implements ScorelineService {

    @Autowired
    private ScorelineRepository scorelineRepository;

    @Override
    public Page<Scoreline> findAll(Pageable pageable) {
        return scorelineRepository.findAll(pageable);
    }

    @Override
    public List<Scoreline> findAll() {
        return scorelineRepository.findAll();
    }

    @Override
    public Scoreline findById(Integer id) {
        return scorelineRepository.findById(id).get();
    }

    @Override
    public Scoreline findByName(String name) {
        return null;
    }

    @Override
    public Scoreline saveOrUpdate(Scoreline scoreline) throws ServiceException {
        return scorelineRepository.save(scoreline);
    }

    @Override
    public boolean checkScoreline(String name) {
        return false;
    }

    @Override
    public void delete(Integer id) {
        scorelineRepository.deleteById(id);
    }
}
