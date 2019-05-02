package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Admin;
import com.jcohy.exam.respository.AdminRepository;
import com.jcohy.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin login(Integer num, String password) throws Exception {
        return adminRepository.findAdminByNum(num);
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(Integer id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public Admin findByNum(Integer num) {
        return adminRepository.findAdminByNum(num);
    }

    @Override
    public Admin findByName(String name) {
        return adminRepository.findAdminByName(name);
    }

    @Override
    public void saveOrUpdate(Admin user) throws ServiceException {
        adminRepository.save(user);
    }

    @Override
    public boolean checkUser(Integer num) {
        Admin dbUser = adminRepository.findAdminByNum(num);
        return dbUser != null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        adminRepository.deleteById(id);
    }

    @Override
    public void updatePassword(Admin user) {
        adminRepository.saveAndFlush(user);
    }
}
