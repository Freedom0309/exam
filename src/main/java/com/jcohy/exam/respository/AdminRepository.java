package com.jcohy.exam.respository;

import com.jcohy.exam.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiac on 2018/4/2.
 * ClassName  : com.jcohy.perfectteaching.repository
 * Description  :
 */
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findAdminByNum(Integer num);

    Admin findAdminByName(String name);

}
