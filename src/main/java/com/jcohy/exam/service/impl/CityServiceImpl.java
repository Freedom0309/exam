package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.City;
import com.jcohy.exam.model.Province;
import com.jcohy.exam.respository.CityRespository;
import com.jcohy.exam.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRespository cityRespository;

    @Override
    public List<City> findAll() {
        return cityRespository.findAll();
    }

    @Override
    public City findById(Integer id) {
        return cityRespository.findById(id).get();
    }

    @Override
    public City saveOrUpdate(City city) {
        return cityRespository.save(city);
    }

    @Override
    public void deleteById(Integer id) {
        if(id == null)
            throw new ServiceException("id不能为空");
        cityRespository.deleteById(id);
    }

    @Override
    public List<City> findByProvince(Province province) {
        return cityRespository.findByProvince(province);
    }

    @Override
    public void deleteAllByProvince(Province province) {
        if (province == null)
            throw new ServiceException("省份不能为空");
        cityRespository.deleteAllByProvince(province);
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRespository.findAll(pageable);
    }

    @Override
    public Integer count() {
        return (int)cityRespository.count();
    }
}
