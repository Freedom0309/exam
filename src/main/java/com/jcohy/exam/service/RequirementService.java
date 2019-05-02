package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Requirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RequirementService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Requirement> findAll(Pageable pageable);

    /**
     *  查询
     * @return
     */
    List<Requirement> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Requirement findById(Integer id);

    /**
     * 新增或者更新需求
     * @param job
     * @return
     */
    Requirement saveOrUpdate(Requirement job) throws ServiceException;

    /**
     * 删除需求
     * @param id
     */
    void delete(Integer id);

    void changeStatus(Integer id,String type,String reason);

    List<Requirement> findByStatus(Integer status);
}
