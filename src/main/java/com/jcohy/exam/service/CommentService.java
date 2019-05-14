package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Batch;
import com.jcohy.exam.model.Comment;
import com.jcohy.exam.model.JobSeeker;
import com.jcohy.exam.model.User;

import java.util.List;

public interface CommentService {


    /**
     *  查询所有留言
     * @return
     */
    List<Comment> findAll();


    /**
     * 根据ID查询留言
     * @param id
     * @return
     */
    Comment findById(Integer id);

    /**
     * 新增或者更新批次
     * @param comment
     * @return
     */
    Comment saveOrUpdate(Comment comment) throws ServiceException;

    /**
     * 删除留言
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据用户查询留言
     * @param user
     * @return
     */
    List<Comment> findByUserId(JobSeeker jobSeeker);

}
