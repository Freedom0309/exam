package com.jcohy.exam.service;

import com.jcohy.exam.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProvinceService {

    Province saveOrUpdate(Province province);

    void deleteById(Integer id);

    List<Province> findAll();

    Province findById(Integer id);

    public Page<Province> findAll(Pageable pageable);
}
