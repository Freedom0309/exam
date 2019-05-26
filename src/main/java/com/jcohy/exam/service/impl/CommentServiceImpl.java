package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Comment;
import com.jcohy.exam.model.JobSeeker;
import com.jcohy.exam.respository.CommentRepository;
import com.jcohy.exam.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Integer id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment saveOrUpdate(Comment comment) throws ServiceException {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
            throw new ServiceException("主建不能为空");
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findByUser(JobSeeker jobSeeker) {
        return commentRepository.findByJobSeeker(jobSeeker);
    }
}
