package com.jcohy.exam.service;

import com.jcohy.exam.model.Batch;
import com.jcohy.exam.model.City;
import com.jcohy.exam.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

    City saveOrUpdate(City city);

    void deleteById(Integer id);

    List<City> findByProvince(Province province);

    void deleteAllByProvince(Province province);

    City findById(Integer id);

    List<City> findAll();


    Page<City> findAll(Pageable pageable);

    Integer count();
}
