package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.College;
import com.jcohy.exam.model.School;
import com.jcohy.exam.respository.SchoolRepository;
import com.jcohy.exam.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public Page<School> findAll(Pageable pageable) {
        return schoolRepository.findAll(pageable);
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School findById(Integer id) {
        return schoolRepository.findById(id).get();
    }

    @Override
    public School findByName(String name) {
        return schoolRepository.findSchoolByName(name);
    }

    @Override
    public School saveOrUpdate(School school) throws ServiceException {
        School dbUser = null;
        if (school.getId() != null) {
            dbUser = findById(school.getId());
            if (school.getAddress() != null) dbUser.setAddress(school.getAddress());
            if (school.getName() != null) dbUser.setName(school.getName());
            if (school.getDescription() != null) dbUser.setDescription(school.getDescription());
            if (school.getLevel() != null) dbUser.setLevel(school.getLevel());
            if (school.getType() != null) dbUser.setType(school.getType());
            if (school.getUrl() != null) dbUser.setUrl(school.getUrl());
        } else {
            dbUser = school;
        }
        return schoolRepository.save(dbUser);
    }

    @Override
    public boolean checkUser(String name) {
        School dbUser = schoolRepository.findSchoolByName(name);
        return dbUser != null;
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new ServiceException("主键不能为空");
        }
        schoolRepository.deleteById(id);
    }

    @Override
    public List<School> findByNameLike(String name) {
        return schoolRepository.findByNameIsLike(name);
    }

}
