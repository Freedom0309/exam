package com.jcohy.exam.respository;

import com.jcohy.exam.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequirementRespository extends JpaRepository<Requirement, Integer> {
    List<Requirement> findAllByStatusGreaterThanEqual(Integer status);

}
