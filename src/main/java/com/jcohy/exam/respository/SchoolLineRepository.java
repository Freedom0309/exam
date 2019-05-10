package com.jcohy.exam.respository;

import com.jcohy.exam.model.SchoolLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolLineRepository extends JpaRepository<SchoolLine, Integer> {

    @Query(value = "select sl.id,s.name as school_id, sl.school_line,sl.arts_science from school_line sl " +
            "left join school s on s.id = sl.school_id ", nativeQuery = true)
    List<Object[]> findAllSchoolLine();
}
