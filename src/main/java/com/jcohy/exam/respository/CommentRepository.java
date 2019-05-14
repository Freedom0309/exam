package com.jcohy.exam.respository;

import com.jcohy.exam.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query(value = "select c from comment c where c.user_id = ?1 ")
    List<Comment> findByUserId(Integer userId);

//    Comment findCommentByName(String name);

}
