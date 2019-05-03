package com.jcohy.exam.respository;

import com.jcohy.exam.model.SchoolProfession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolProfessionRepository extends JpaRepository<SchoolProfession,Integer> {

    SchoolProfession findSchoolProfessionByProfessionId(Integer professionId);

    SchoolProfession findSchoolProfessionBySchoolId(Integer schoolId);

}
