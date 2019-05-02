package com.jcohy.exam.respository;

import com.jcohy.exam.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Integer> {

    Resume findResumeByNum(Integer num);

    Resume findResumeByName(String name);

}
