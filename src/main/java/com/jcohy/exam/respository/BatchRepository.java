package com.jcohy.exam.respository;

import com.jcohy.exam.model.Batch;
import com.jcohy.exam.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch,Integer> {

    Batch findBatchByBatchNumber(Integer batchNumber);

    List<Batch> findBySchool(School school);

}
