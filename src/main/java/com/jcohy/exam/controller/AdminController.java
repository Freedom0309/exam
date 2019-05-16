package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.model.JobSeeker;
import com.jcohy.exam.service.AdminService;
import com.jcohy.exam.service.JobSeekerService;
import com.jcohy.exam.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiac on 2018/4/2.
 * ClassName  : com.jcohy.perfectteaching.controller
 * Description  :
 */

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

    @Autowired
    private AdminService adminService;

    @Autowired
    private JobSeekerService jobSeekerService;

    /**
     * 查找待删除求职者
     * @param
     * @return
     */
    @GetMapping("/getDeleteJobSeeker")
    public JsonResult getDeleteJobSeeker( ){
        try {
            List<JobSeeker> list = jobSeekerService.findAll();
            List<JobSeeker> list1 = new ArrayList<>();
            for (JobSeeker jobSeeker : list) {
                    list1.add(jobSeeker);
            }
            return JsonResult.ok().set("data", list1);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 删除求职者
     * @param jobSeeker
     * @return
     */
    @GetMapping("/deleteJobSeeker")
    public JsonResult deleteJobSeeker(JobSeeker jobSeeker){
        try {
            jobSeekerService.delete(jobSeeker.getId());
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 删除全部待删除的求职者
     * @return
     */
    @GetMapping("/deleteAllJobSeeker")
    public JsonResult deleteAllJobSeeker(){
        try {
            List<JobSeeker> list = jobSeekerService.findAll();
            for (JobSeeker jobSeeker : list) {
                    jobSeekerService.delete(jobSeeker.getId());
            }
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

}
