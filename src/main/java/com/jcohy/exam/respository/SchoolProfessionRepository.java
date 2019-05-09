package com.jcohy.exam.respository;

import com.jcohy.exam.model.SchoolProfession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolProfessionRepository extends JpaRepository<SchoolProfession,Integer>{

    SchoolProfession findSchoolProfessionByProfessionId(Integer professionId);

    @Query(value = "select * from profession p " +
            "left join school_profession s on s.profession_id = p.id " +
            "where s.school_id = :schoolId",
        nativeQuery = true)
    List<Object> findProfessionBySchool(Integer schoolId);

}
