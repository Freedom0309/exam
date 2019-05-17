package com.jcohy.exam.respository;

import com.jcohy.exam.model.City;
import com.jcohy.exam.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.PropertyVetoException;
import java.util.List;

public interface CityRespository extends JpaRepository<City, Integer> {

    List<City> findByProvince(Province province);

    void deleteAllByProvince(Province province);
}
