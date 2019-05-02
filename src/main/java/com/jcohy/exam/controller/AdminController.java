package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.model.Admin;
import com.jcohy.exam.model.College;
import com.jcohy.exam.model.JobSeeker;
import com.jcohy.exam.model.Resume;
import com.jcohy.exam.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SchoolService schoolService;


    /**
     * 查找待删除学院
     * @param
     * @return
     */
    @GetMapping("/getDeleteCollege")
    public JsonResult getDeleteCollege( ){
        try {
            List<College> list = collegeService.findAll();
            List<College> list1 = new ArrayList<>();
            for (College college : list) {
                if (college.getStatus() == 1) {
                    list1.add(college);
                }
            }
            return JsonResult.ok().set("data", list1);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 删除学院
     * @param college
     * @return
     */
    @GetMapping("/deleteCollege")
    public JsonResult deleteCollege(College college){
        try {
            collegeService.delete(college.getId());
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 删除全部待删除学院
     * @return
     */
    @GetMapping("/deleteAllCollege")
    public JsonResult deleteAllCollege(){
        try {
            List<College> list = collegeService.findAll();
            for (College college : list) {
                if (college.getStatus() == 1) {
                    collegeService.delete(college.getId());
                }
            }
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


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
                if (jobSeeker.getStatus() == 1) {
                    list1.add(jobSeeker);
                }
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
                if (jobSeeker.getStatus() == 1) {
                    jobSeekerService.delete(jobSeeker.getId());
                }
            }
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 查找待删除简历
     * @param
     * @return
     */
    @GetMapping("/getDeleteResume")
    public JsonResult getDeleteResume( ){
        try {
            List<Resume> list = resumeService.findAll();
            List<Resume> list1 = new ArrayList<>();
            for (Resume resume : list) {
                if (resume.getStatus() == 1) {
                    list1.add(resume);
                }
            }
            return JsonResult.ok().set("data", list1);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 删除简历
     * @param resume
     * @return
     */
    @GetMapping("/deleteResume")
    public JsonResult deleteJobSeeker(Resume resume){
        try {
            resumeService.delete(resume.getId());
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 删除全部待删除的简历
     * @return
     */
    @GetMapping("/deleteAllResume")
    public JsonResult deleteAllResume(){
        try {
            List<Resume> list = resumeService.findAll();
            for (Resume resume : list) {
                if (resume.getStatus() == 1) {
                    resumeService.delete(resume.getId());
                }
            }
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    @GetMapping("/list")
    @ResponseBody
    public PageJson<Resume> all(@SessionAttribute("user")Admin teacher, ModelMap map){
        PageRequest pageRequest = getPageRequest();
        Page<Resume> plans = resumeService.findAll(pageRequest);
        PageJson<Resume> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(plans.getSize());
        page.setData(plans.getContent());
        return page;
    }

}
