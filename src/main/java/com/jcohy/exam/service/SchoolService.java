package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.College;
import com.jcohy.exam.model.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<School> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<School> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    School findById(Integer id);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    School findByName(String name);

    /**
     * 新增或者更新学院
     * @param school
     * @return
     */
    School saveOrUpdate(School school) throws ServiceException;

    /**
     * 检查学院是否存在
     * @param name 学校名称
     * @return
     */
    boolean checkUser(String name);

    /**
     * 删除学院
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据名称模糊查询学校
     * @param name
     * @return
     */
    List<School> findByNameLike(String name);
}
