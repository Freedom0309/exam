package com.jcohy.exam.respository;

import com.jcohy.exam.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch,Integer> {

    Batch findBatchByBatchNumber(Integer batchNumber);

}
