package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.College;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CollegeService {
    /**
     * 学院登录
     * @param num  学院编号
     * @param password
     * @return
     * @throws Exception
     */
    College login(Integer num, String password) throws Exception;


    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<College> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<College> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    College findById(Integer id);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    College findByName(String name);

    /**
     * 根据num查询
     * @param num
     * @return
     */
    College findByNum(Integer num);

    /**
     * 新增或者更新学院
     * @param college
     * @return
     */
    College saveOrUpdate(College college) throws ServiceException;

    /**
     * 检查学院是否存在
     * @param num
     * @return
     */
    boolean checkUser(Integer num);

    /**
     * 删除学院
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改学院密码
     *
     * @param college
     * @param oldpassword
     * @param password1
     * @param password2
     */
    void updatePassword(College college);
}
