package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {
    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Job> findAll(Pageable pageable);

    /**
     *  查询
     * @return
     */
    List<Job> findAll();

    /**
     *  查询
     * @return
     */
    List<Job> findAllByStatus();

    /**
     * 模糊查询
     *
     * @return
     */
    List<Job> findByNameLike(String name);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Job findById(Integer id);


    /**
     * 新增或者更新职位
     * @param job
     * @return
     */
    Job saveOrUpdate(Job job) throws ServiceException;


    /**
     * 删除职位
     * @param id
     */
    void delete(Integer id);

    void changeStatus(Integer id);
}
