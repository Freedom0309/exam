package com.jcohy.exam.respository;

import com.jcohy.exam.model.College;
import com.jcohy.exam.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {

//    School findSchoolByNum(Integer num);


    School findSchoolByName(String name);

}
