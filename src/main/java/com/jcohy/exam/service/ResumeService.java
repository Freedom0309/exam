package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Resume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResumeService {
    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Resume> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<Resume> findAll();


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Resume findById(Integer id);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    Resume findByName(String name);

    /**
     * 新增或者更新简历
     * @param resume
     */
    Resume saveOrUpdate(Resume resume) throws ServiceException;


    /**
     * 删除简历
     * @param id
     */
    void delete(Integer id);

}
