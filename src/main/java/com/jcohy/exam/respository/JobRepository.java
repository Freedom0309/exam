package com.jcohy.exam.respository;

import com.jcohy.exam.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer> {

    @Query(value = "select * from job a where a.name like %?1%", nativeQuery = true)
    List<Job> findByName(String name);

    List<Job> findByStatus(Integer status);
}
