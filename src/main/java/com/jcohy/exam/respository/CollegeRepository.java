package com.jcohy.exam.respository;

import com.jcohy.exam.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Integer> {

    College findCollegeByNum(Integer num);


    College findCollegeByName(String name);

}
