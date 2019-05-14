package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.model.Comment;
import com.jcohy.exam.service.CommentService;
import com.jcohy.exam.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/save")
    public JsonResult save(Comment comment, HttpSession session){
        Object user = session.getAttribute("user");

        commentService.saveOrUpdate(comment);
        return JsonResult.ok();
    }
}
