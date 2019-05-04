package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Scoreline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ScorelineService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Scoreline> findAll(Pageable pageable);


    /**
     *  查询所有专业
     * @return
     */
    List<Scoreline> findAll();


    /**
     * 根据ID查询专业
     * @param id
     * @return
     */
    Scoreline findById(Integer id);

    /**
     * 根据name查询专业
     * @param name
     * @return
     */
    Scoreline findByName(String name);

    /**
     * 新增或者更新专业
     * @param scoreline
     * @return
     */
    Scoreline saveOrUpdate(Scoreline scoreline) throws ServiceException;

    /**
     * 检查专业是否存在
     * @param name 专业名称
     * @return
     */
    boolean checkScoreline(String name);

    /**
     * 删除专业
     * @param id
     */
    void delete(Integer id);

}
