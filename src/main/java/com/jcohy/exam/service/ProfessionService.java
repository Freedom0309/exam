package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Profession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfessionService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Profession> findAll(Pageable pageable);


    /**
     *  查询所有专业
     * @return
     */
    List<Profession> findAll();


    /**
     * 根据ID查询专业
     * @param id
     * @return
     */
    Profession findById(Integer id);

    /**
     * 根据name查询专业
     * @param name
     * @return
     */
    Profession findByName(String name);

    /**
     * 新增或者更新专业
     * @param profession
     * @return
     */
    Profession saveOrUpdate(Profession profession) throws ServiceException;

    /**
     * 删除专业
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据名字模糊专业
     * @param name
     * @return
     */
    List<Profession> findByNameIsLike(String name);

    /**
     *
     * @param city
     * @param arts
     * @param score
//     * @param grage
     * @return
     */
//    List<Object[]> findProfession(String city, String arts, Integer score, Integer grage);
    List<Object[]> findProfession(String city, String arts, Integer score);

}
