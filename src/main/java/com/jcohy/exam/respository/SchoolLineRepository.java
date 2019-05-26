package com.jcohy.exam.respository;

import com.jcohy.exam.model.SchoolLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolLineRepository extends JpaRepository<SchoolLine, Integer> {


    @Query(value = "select sl.id,s.name as school_id, sl.school_line, sl.arts_science, p.name from school_line sl " +
            "left join school s on s.id = sl.school_id " +
            "left join profession p on p.id = sl.profession_id " +
            "where 1=1 limit :page, :size", nativeQuery = true)
    List<Object[]> findAllSchoolLine(@Param("page") Integer page, @Param("size") Integer size);
}
