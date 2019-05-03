package com.jcohy.exam.respository;

import com.jcohy.exam.model.Scoreline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScorelineRepository extends JpaRepository<Scoreline,Integer> {

    Scoreline findScorelineByBatchNumber(Integer batchNumber);

}
