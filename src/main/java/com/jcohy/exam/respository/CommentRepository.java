package com.jcohy.exam.respository;

import com.jcohy.exam.model.Comment;
import com.jcohy.exam.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    /*@Query(value = "select c.id,c.content,c.time from comment c " +
            "left join where c.user_id = ?1 "
        ,nativeQuery = true)*/
    List<Comment> findByJobSeeker(JobSeeker jobSeeker);

//    Comment findCommentByName(String name);

}
