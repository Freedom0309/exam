package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Province;
import com.jcohy.exam.respository.ProvinceRespository;
import com.jcohy.exam.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {


    @Autowired
    private ProvinceRespository provinceRespository;

    @Override
    public Province saveOrUpdate(Province province) {
        return provinceRespository.save(province);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null)
            throw new ServiceException("id不能为空");
        provinceRespository.deleteById(id);
    }

    @Override
    public List<Province> findAll() {
        return provinceRespository.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRespository.findAll(pageable);
    }

    @Override
    public Province findById(Integer id) {
        return provinceRespository.findById(id).get();
    }
}
