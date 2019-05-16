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

    List<Profession> findByNameIsLike(String name);

    @Query(value = "select distinct p.id, p.name as pname ,s.name as sname, sl.school_line from profession p " +
            "left join school_profession sp on sp.profession_id = p.id " +
            "left join school s on s.id = sp.school_id " +
            "left join school_line sl on sl.profession_id = p.id and sl.school_id = sp.school_id " +
            "where s.address like %?1% and sl.arts_science = ?2 " +
            "and sl.school_line < ?3 ",
            nativeQuery = true)
    List<Object[]> findProfession( String address,  String artsScience,
                                   Integer score);

}
