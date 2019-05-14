package com.jcohy.exam.controller;

import com.jcohy.date.DateUtils;
import com.jcohy.lang.StringUtils;
import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.*;
import com.jcohy.exam.service.DeliveryRecordService;
import com.jcohy.exam.service.JobSeekerService;
import com.jcohy.exam.service.JobService;
import com.jcohy.exam.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jobSeeker")
public class JobSeekerController extends BaseController{

    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private JobService jobService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private DeliveryRecordService deliveryRecordService;


    /**
     * 求职者登陆接口
     * @param num 登录号
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public JsonResult login(HttpServletRequest request,Integer num, String password){
        JobSeeker login = null;
        try {
            if(num == null || StringUtils.isEmpty(password)){
                return JsonResult.fail("用户名或者密码不能为空");
            }

            login = jobSeekerService.login(num, password);

            if(login == null){
                return JsonResult.fail("登录失败,用户名不存在");
            }
            if(!login.getPassword().equals(password)){
                return JsonResult.fail("登录失败,用户名账号密码不匹配");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("user",login);
        return JsonResult.ok("登录成功").set("data",login);
    }

    /**
     * 注册接口
     * @param num 账号 必填
     * @param phone 电话 必填
     * @param password 密码 必填
     * @param name 姓名 必填
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public JsonResult register(Integer num, String phone, String password,
                               String name, String sex, String email){
        if(num == null||phone == null || StringUtils.hashEmpty(name,password)){
            return JsonResult.fail("参数不能为空");
        }
        boolean exist = jobSeekerService.checkUser(num);
        if(exist){
            return JsonResult.fail("用户已存在");
        }
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setNum(num);
        jobSeeker.setPassword(password);
        jobSeeker.setName(name);
        jobSeeker.setPhone(phone);
        jobSeeker.setSex(sex);
        jobSeeker.setEmail(email);
        jobSeekerService.saveOrUpdate(jobSeeker);
        return JsonResult.ok("注册成功").set("data", jobSeeker);
    }


    /**
     * 修改密码
     *
     * @param jobSeeker
     * @return
     */
    @GetMapping("/changePass")
    @ResponseBody
    public JsonResult changePass(JobSeeker jobSeeker, String oldP, String newP) {
        try {
            jobSeekerService.updatePassword(jobSeeker, oldP, newP, newP);
            return JsonResult.ok("修改成功");
        } catch (ServiceException e) {
            return JsonResult.fail(e.getMessage());
        }
    }

    @GetMapping("/update")
    @ResponseBody
    public JsonResult updateUserInfo(JobSeeker jobSeeker, String birth1){

        try {
            Date str = DateUtils.strToDate(birth1);
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = simpleDateFormat.parse(birth1);
            jobSeeker.setBirth(str);
            jobSeekerService.saveOrUpdate(jobSeeker);
            return JsonResult.ok().set("data", jobSeeker);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 增加简历
     *
     * @param resume
     * @return
     */
    @PostMapping("/addResume")
    @ResponseBody
    public JsonResult addResume(Resume resume,String births) {
        try {
            Date str = DateUtils.strToDate(births);
            resume.setBirth(str);
            Resume res = resumeService.saveOrUpdate(resume);
            JobSeeker jobSeeker = jobSeekerService.findByNum(res.getNum());
//            jobSeeker.setResume(res);
            jobSeeker = jobSeekerService.saveOrUpdate(jobSeeker);
            return JsonResult.ok("添加成功").set("data", res).set("data", jobSeeker);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 获取全部job
     * @return
     */
    @GetMapping("/jobs")
    @ResponseBody
    public JsonResult findAllJobs(){
        List<Job> all = jobService.findAll();
        return JsonResult.ok("获取成功").set("data",all);
    }


    /**
     * 搜索job模糊查询
     * @param key
     * @return
     */
    @GetMapping("/searchJob")
    @ResponseBody
    public JsonResult searchJob(String key){
        List<Job> list = jobService.findByNameLike(key);
        return JsonResult.ok().set("data", list);
    }


    /**
     * 获取job详情
     * @return
     */
    @GetMapping("/job/{id}")
    public String jobDetail(@PathVariable Integer id, ModelMap map){
        Job job = jobService.findById(id);
        map.put("job",job);
        return "front/detail";
    }


    /**
     * 投递job
     * @param userId  用户id
     * @param  jobId  工作id
     */
    @GetMapping("/send")
    @ResponseBody
    public JsonResult send(Integer userId, Integer jobId){
        try {
            JobSeeker jobSeeker = jobSeekerService.findById(userId);
            Job job = jobService.findById(jobId);
//            if (jobSeeker.getResume() == null) {
//                return JsonResult.fail("还没有简历，先去添加一份简历吧！");
//            }
            List<DeliveryRecord> list = new ArrayList<>();
            list = deliveryRecordService.findAll();
            for (DeliveryRecord deliveryRecord : list) {
                if (userId == deliveryRecord.getJobSeeker().getId() && jobId == deliveryRecord.getJob().getId()) {
                    return JsonResult.fail("已经投递过了，不能重复投递！");
                }
            }
            DeliveryRecord deliveryRecord = new DeliveryRecord();
            deliveryRecord.setCollegeId(job.getCollege().getId());
            deliveryRecord.setJobSeeker(jobSeeker);
//            deliveryRecord.setResumeId(jobSeeker.getResume().getId());
            deliveryRecord.setJob(job);
            deliveryRecord.setNum(jobSeeker.getId());
            Date date = new Date();
            deliveryRecord.setDeliveryTime(date);
            deliveryRecordService.saveOrUpdate(deliveryRecord);
            return JsonResult.ok("投递成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 查看投递记录
     * @param userId
     * @return
     */
    @GetMapping("/deliveryRecord")
    @ResponseBody
    public JsonResult findSend(Integer userId){
        List<DeliveryRecord> list = new ArrayList<>();
        list = deliveryRecordService.findListByNum(userId);
        return JsonResult.ok("获取成功").set("data",list);
    }


    /**
     * 查看投递记录详情
     * @param id
     * @return
     */
    @GetMapping("/deliveryRecord/{id}")
    @ResponseBody
    public JsonResult deliveryRecord(@PathVariable Integer id){
        DeliveryRecord deliveryRecord = deliveryRecordService.findById(id);
        return JsonResult.ok("获取成功").set("data",deliveryRecord);
    }



    /**
     * 取消投递
     * @param deliveryRecord
     * @return
     */
    @GetMapping("/deleteRecord")
    @ResponseBody
    public JsonResult deleteRecord(DeliveryRecord deliveryRecord){
        deliveryRecordService.delete(deliveryRecord.getId());
        return JsonResult.ok("取消投递成功");
    }



    @GetMapping("/list")
    @ResponseBody
    public PageJson<JobSeeker> all(@SessionAttribute("user")Admin teacher, ModelMap map){
        PageRequest pageRequest = getPageRequest();
        Page<JobSeeker> plans = jobSeekerService.findAll(pageRequest);
        PageJson<JobSeeker> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(plans.getSize());
        page.setData(plans.getContent());
        return page;
    }

}
