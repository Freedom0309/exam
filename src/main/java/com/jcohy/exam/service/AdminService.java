package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminService {
    /**
     * 用户登录
     * @param num  管理员编号
     * @param password
     * @return
     * @throws Exception
     */
    Admin login(Integer num, String password) throws Exception;


    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Admin> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<Admin> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Admin findById(Integer id);

    /**
     * 根据ID查询
     * @param num
     * @return
     */
    Admin findByNum(Integer num);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    Admin findByName(String name);

    /**
     * 新增或者更新用户
     * @param user
     */
    void saveOrUpdate(Admin user) throws ServiceException;

    /**
     * 检查用户是否存在
     * @param num
     * @return
     */
    boolean checkUser(Integer num);

    /**
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改用户密码
     * @param user
     * @param oldpassword
     * @param password1
     * @param password2
     */
    void updatePassword(Admin user);
}

