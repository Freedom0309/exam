package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.model.College;
import com.jcohy.exam.model.Job;
import com.jcohy.exam.model.Requirement;
import com.jcohy.exam.service.CollegeService;
import com.jcohy.exam.service.DeliveryRecordService;
import com.jcohy.exam.service.JobService;
import com.jcohy.exam.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jiac on 2018/5/21.
 * ClassName  : com.jcohy.exam.controller
 * Description  :
 */
@Controller
@RequestMapping("/job")
public class JobController extends BaseController {

    @Autowired
    private JobService jobService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private RequirementService requirementService;

    @Autowired
    private DeliveryRecordService deliveryRecordService;

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Job> all() {
        PageRequest pageRequest = getPageRequest();
        Page<Job> jobs = jobService.findAll(pageRequest);
        PageJson<Job> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(jobs.getContent().size());
        page.setData(jobs.getContent());
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){
        List<College> colleges = collegeService.findAll();
        List<Requirement> requirements = requirementService.findAll();
        map.put("colleges",colleges);
        map.put("requirements",requirements);
        if(id != null){
            Job job = jobService.findById(id);
            map.put("job",job);
        }
        return "admin/job/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Job job){
        try {
            jobService.saveOrUpdate(job);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.ok();
    }

    @GetMapping("/change/{id}")
    @ResponseBody
    public JsonResult change(@PathVariable("id") Integer id){
        jobService.changeStatus(id);
        return JsonResult.ok();
    }

    /**
     * 删除job
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    public JsonResult deleteJob(@PathVariable("id") Integer id){
        try {
            jobService.delete(id);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }
}
