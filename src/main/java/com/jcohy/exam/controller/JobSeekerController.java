package com.jcohy.exam.controller;

import com.jcohy.date.DateUtils;
import com.jcohy.lang.StringUtils;
import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.*;
import com.jcohy.exam.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/jobSeeker")
public class JobSeekerController extends BaseController{

    @Autowired
    private JobSeekerService jobSeekerService;


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
                               String name, String sex, String email, Integer age, String birth){
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
        jobSeeker.setAge(age);
        jobSeeker.setBirth(DateUtils.strToDate(birth));
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
    public JsonResult updateUserInfo(JobSeeker jobSeeker){

        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = simpleDateFormat.parse(birth1);
//            jobSeeker.setBirth(str);
            jobSeekerService.saveOrUpdate(jobSeeker);
            return JsonResult.ok().set("data", jobSeeker);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
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
