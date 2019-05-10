package com.jcohy.exam.respository;

import com.jcohy.exam.model.Profession;
import com.jcohy.exam.model.SchoolProfession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolProfessionRepository extends JpaRepository<SchoolProfession,Integer>{

    SchoolProfession findSchoolProfessionByProfessionId(Integer professionId);

    @Query(value = "select p.* from profession p " +
            "left join school_profession s on s.profession_id = p.id " +
            "where s.school_id = :schoolId",
        nativeQuery = true)
    List<Object[]> findProfessionBySchool(@Param("schoolId") Integer schoolId);

    SchoolProfession findBySchoolIdAndProfessionId(Integer schoolId, Integer professionId);

    List<SchoolProfession> findAllBySchoolId(Integer schoolId);

    void deleteBySchoolIdAndProfessionId(Integer schoolId, Integer professionId);

    void deleteBySchoolId(Integer schoolId);



}
