package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Batch;
import com.jcohy.exam.model.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BatchService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Batch> findAll(Pageable pageable);


    /**
     *  查询所有批次
     * @return
     */
    List<Batch> findAll();


    /**
     * 根据ID查询批次
     * @param id
     * @return
     */
    Batch findById(Integer id);

    /**
     * 新增或者更新批次
     * @param Batch
     * @return
     */
    Batch saveOrUpdate(Batch Batch) throws ServiceException;

    /**
     * 检查批次是否存在
     * @param name 专业名称
     * @return
     */
    boolean checkBatch(String name);

    /**
     * 删除批次
     * @param id
     */
    void delete(Integer id);

    /**
     * 查询学校的所有批次
     * @param school 学校
     * @return 学校的所有批次
     */
    List<Batch> findBySchool(School school);

}
