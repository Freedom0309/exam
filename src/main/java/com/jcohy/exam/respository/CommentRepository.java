package com.jcohy.exam.respository;

import com.jcohy.exam.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment findCommentByUserId(Integer userId);

//    Comment findCommentByName(String name);

}
