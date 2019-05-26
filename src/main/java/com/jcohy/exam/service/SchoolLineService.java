package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.School;
import com.jcohy.exam.model.SchoolLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolLineService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SchoolLine> findAll(Pageable pageable);

    List<Object[]> findAllSchoolLine(Integer page, Integer size);

    long count();

    /**
     *  查询
     * @return
     */
    List<SchoolLine> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    SchoolLine findById(Integer id);

    /**
     * 新增或者更新学校分数线
     * @param schoolLine
     * @return
     */
    SchoolLine saveOrUpdate(SchoolLine schoolLine) throws ServiceException;

    /**
     * 删除学校分数线
     * @param id
     */
    void delete(Integer id);

}
