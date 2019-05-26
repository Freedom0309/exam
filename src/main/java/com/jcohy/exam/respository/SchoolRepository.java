package com.jcohy.exam.respository;

import com.jcohy.exam.model.College;
import com.jcohy.exam.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Integer> {

//    School findSchoolByNum(Integer num);

   // @Query(value = "select * from school a where a.name like %?1%", nativeQuery = true)
    List<School> findByNameIsLike(String name);

    School findSchoolByName(String name);

}
