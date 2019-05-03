package com.jcohy.exam.respository;

import com.jcohy.exam.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession,Integer> {

    Profession findProfessionById(Integer id);

    Profession findProfessionByName(String name);

}
