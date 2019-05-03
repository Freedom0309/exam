package com.jcohy.exam.respository;

import com.jcohy.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByName(String name);

}
