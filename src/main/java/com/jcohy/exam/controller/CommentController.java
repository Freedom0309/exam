package com.jcohy.exam.controller;

import com.jcohy.date.DateUtils;
import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.model.Comment;
import com.jcohy.exam.model.JobSeeker;
import com.jcohy.exam.service.CommentService;
import com.jcohy.exam.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Comment comment, HttpSession session, HttpServletRequest request){
        try {
            JobSeeker user = (JobSeeker)session.getAttribute("user");
            Enumeration<String> attributeNames = request.getSession().getAttributeNames();
            comment.setJobSeeker(user);
            comment.setTime(DateUtils.strToDate(DateUtils.getCurrentDateStr()));
            commentService.saveOrUpdate(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }

        List<Comment> comments = commentService.findAll();
        return JsonResult.ok().set("data", comments);
    }

    @GetMapping("/list")
    @ResponseBody
    public JsonResult getAll(){
        List<Comment> lists = commentService.findAll();
        return JsonResult.ok().set("data", lists);
    }
}
