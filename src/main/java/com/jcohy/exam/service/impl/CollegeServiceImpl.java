package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.College;
import com.jcohy.exam.respository.CollegeRepository;
import com.jcohy.exam.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public College login(Integer num, String password) throws Exception {
        return collegeRepository.findCollegeByNum(num);
    }

    @Override
    public Page<College> findAll(Pageable pageable) {
        return collegeRepository.findAll(pageable);
    }

    @Override
    public List<College> findAll() {
        return collegeRepository.findAll();
    }

    @Override
    public College findById(Integer id) {
        return collegeRepository.findById(id).get();
    }

    @Override
    public College findByName(String name) {
        return collegeRepository.findCollegeByName(name);
    }

    @Override
    public College findByNum(Integer num) {
        return collegeRepository.findCollegeByNum(num);
    }


    @Override
    public College saveOrUpdate(College college) throws ServiceException {
        College dbUser =null;
        if(college.getId() != null){
            dbUser = findById(college.getId());
            if(college.getCollegeChairman() != null ) dbUser.setCollegeChairman(college.getCollegeChairman());
            if(college.getName() != null ) dbUser.setName(college.getName());
            if(college.getCollegeDesc() != null ) dbUser.setCollegeDesc(college.getCollegeDesc());
            if(college.getCollegeTel() != null ) dbUser.setCollegeTel(college.getCollegeTel());
            if(college.getEmail() != null ) dbUser.setEmail(college.getEmail());
            if(college.getPassword() != null ) dbUser.setPassword(college.getPassword());
        }else{
            dbUser = college;
        }
        dbUser.setUpdateTime(new Date());
        return collegeRepository.save(dbUser);
    }

    @Override
    public boolean checkUser(Integer num) {
        College dbUser = collegeRepository.findCollegeByNum(num);
        return dbUser != null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        collegeRepository.deleteById(id);
    }

    @Override
    public void updatePassword(College college) {
        collegeRepository.saveAndFlush(college);
    }
}
