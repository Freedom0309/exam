package com.jcohy.exam.respository;

import com.jcohy.exam.model.SchoolBatch;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolBatchRepository
        extends JpaRepository<SchoolBatch,Integer> {

    SchoolBatch findSchoolBatchBySchoolId(Integer schoolId);

    SchoolBatch findSchoolBatchBybatchId(Integer batchId);

}
