package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Requirement;
import com.jcohy.exam.respository.RequirementRespository;
import com.jcohy.exam.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementRespository requirementRespository;


    @Override
    public Page<Requirement> findAll(Pageable pageable) {
        return requirementRespository.findAll(pageable);
    }

    @Override
    public List<Requirement> findAll() {
        return requirementRespository.findAll();
    }

    @Override
    public Requirement findById(Integer id) {
        return requirementRespository.findById(id).get();
    }

    @Override
    public Requirement saveOrUpdate(Requirement requirement) throws ServiceException {
        Requirement dbUser = null;
        if(requirement.getId() != null){
            dbUser = findById(requirement.getId());
            if(requirement.getCollege() != null ) dbUser.setCollege(requirement.getCollege());
            if(requirement.getName() != null ) dbUser.setName(requirement.getName());
            if(requirement.getDesc() != null ) dbUser.setDesc(requirement.getDesc());
            if(requirement.getNum() != null ) dbUser.setNum(requirement.getNum());
            if(requirement.getStatus() != null ) dbUser.setStatus(requirement.getStatus());
            if(requirement.getReason() != null ) dbUser.setReason(requirement.getReason());
        }else{
            dbUser = requirement;
            dbUser.setStatus(0);
        }
        dbUser.setCreateTime(new Date());
        return requirementRespository.save(dbUser);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        requirementRespository.deleteById(id);
    }

    @Override
    public void changeStatus(Integer id, String type,String reason) {

        Requirement requirement = findById(id);
        requirement.setReason(reason);
        requirement.setStatus(Integer.parseInt(type));
        requirementRespository.saveAndFlush(requirement);
    }

    @Override
    public List<Requirement> findByStatus(Integer status) {
        return requirementRespository.findAllByStatusGreaterThanEqual(status);
    }
}
