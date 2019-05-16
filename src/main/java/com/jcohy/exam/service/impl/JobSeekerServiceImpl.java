package com.jcohy.exam.service.impl;

import com.jcohy.lang.StringUtils;
import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.JobSeeker;
import com.jcohy.exam.respository.JobSeekerRepository;
import com.jcohy.exam.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Override
    public JobSeeker login(Integer num, String password) throws Exception {
        return jobSeekerRepository.findJobSeekerByNum(num);
    }

    @Override
    public Page<JobSeeker> findAll(Pageable pageable) {
        return jobSeekerRepository.findAll(pageable);
    }

    @Override
    public List<JobSeeker> findAll() {
        return jobSeekerRepository.findAll();
    }

    @Override
    public JobSeeker findById(Integer id) {
        return jobSeekerRepository.findById(id).get();
    }

    @Override
    public JobSeeker findByName(String name) {
        return jobSeekerRepository.findJobSeekerByName(name);
    }

    @Override
    public JobSeeker findByNum(Integer num) {
        return jobSeekerRepository.findJobSeekerByNum(num);
    }


    @Override
    public JobSeeker saveOrUpdate(JobSeeker jobSeeker) throws ServiceException {
        JobSeeker dbUser =null;
        if(jobSeeker.getId() != null){
            dbUser = findById(jobSeeker.getId());
            if(jobSeeker.getBirth() != null ) dbUser.setBirth(jobSeeker.getBirth());
            if(jobSeeker.getName() != null ) dbUser.setName(jobSeeker.getName());
            if(jobSeeker.getSex() != null ) dbUser.setSex(jobSeeker.getSex());
            if(jobSeeker.getEmail() != null ) dbUser.setEmail(jobSeeker.getEmail());
            if(jobSeeker.getPhone() != null ) dbUser.setPhone(jobSeeker.getPhone());
            if(jobSeeker.getPassword() != null ) dbUser.setPassword(jobSeeker.getPassword());
            if(jobSeeker.getAge() != null ) dbUser.setAge(jobSeeker.getAge());
        }else{
            dbUser = jobSeeker;
        }
        return jobSeekerRepository.save(dbUser);
    }

    @Override
    public boolean checkUser(Integer num) {
        JobSeeker dbUser = jobSeekerRepository.findJobSeekerByNum(num);
        return dbUser != null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        jobSeekerRepository.deleteById(id);
    }

    @Override
    public void updatePassword(JobSeeker jobSeeker, String oldpassword, String password1, String password2) {
        if(StringUtils.isBlank(oldpassword) || StringUtils.isBlank(password1) || StringUtils.isBlank(password2)){
            throw new ServiceException("参数不完整");
        }
        if(!password1.equals(password2)){
            throw new ServiceException("两次输入密码不一致");
        }
        JobSeeker dbUser = findById(jobSeeker.getId());
        if(!dbUser.getPassword().equals(oldpassword)){
            throw new ServiceException("旧密码不正确");
        }
        dbUser.setPassword(password1);
        jobSeekerRepository.saveAndFlush(dbUser);
    }
}
