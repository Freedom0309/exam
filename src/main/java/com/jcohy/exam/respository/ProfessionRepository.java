package com.jcohy.exam.respository;

import com.jcohy.exam.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessionRepository extends JpaRepository<Profession,Integer> {

    Profession findByName(String name);

    /*@Query(value = "select p.* from profession p " +
            "left join school_profession s on s.profession_id = p.id " +
            "where s.school_id = :schoolId",
            nativeQuery = true)
    List<Profession> findBySchoolId(@Param("schoolId") Integer schoolId);*/

}
