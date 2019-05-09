package com.jcohy.exam.controller;

import com.google.gson.Gson;
import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.model.*;
import com.jcohy.exam.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/school")
public class SchoolController extends BaseController {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolProfessionService schoolProfessionService;

    private ProfessionService professionService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private DeliveryRecordService deliveryRecordService;

    @Autowired
    private RequirementService requirementService;


    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map) {
        List<School> schools = schoolService.findAll();
        map.put("schools", schools);
        if (id != null) {
            School school = schoolService.findById(id);
            map.put("school", school);
        }
        return "admin/school/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(School school) {
        try {
            schoolService.saveOrUpdate(school);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.ok();
    }

    /**
     * 查询所有学校
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public PageJson<School> all() {
        PageRequest pageRequest = getPageRequest();
        Page<School> schools = schoolService.findAll(pageRequest);
        PageJson<School> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(schools.getSize());
        page.setData(schools.getContent());
        return page;
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteSchool(@PathVariable("id") Integer id) {
        try {
            schoolService.delete(id);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 更新学院信息
     *
     * @param school
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(School school) {
        try {
            School sch = schoolService.saveOrUpdate(school);
            return JsonResult.ok().set("data", sch);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 添加专业页面
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/profession")
    public String getAllProfession(@RequestParam(required = true) Integer id, ModelMap map){

        School school = schoolService.findById(id);
        map.put("school", school);

        return "admin/school/profession";
    }


    /**
     * 给学校下新增专业
     * @param ids
     * @param schoolId
     * @return
     */
    @PostMapping("/saveProfession")
    @ResponseBody
    public JsonResult saveProfession(@RequestParam("ids") String ids, Integer schoolId){

        ids = ids.substring(1, ids.length() - 1);
        List<SchoolProfession> professions = new ArrayList<>();
        String[] strs = ids.split(",");
        for (int i = 0; i < strs.length; i++) {
            SchoolProfession schoolProfession = new SchoolProfession();
            schoolProfession.setProfessionId(Integer.valueOf(strs[i]));
            schoolProfession.setSchoolId(schoolId);
            professions.add(schoolProfession);
        }
        schoolProfessionService.batchSave(professions);

        return JsonResult.ok();
    }

    /**
     * 学校中已有的专业页面
     * @param id 学校id
     * @return
     */
    @GetMapping("pressionBySchool")
    public String pressionBySchool(@RequestParam(required = true) Integer id, ModelMap map){

        School school = schoolService.findById(id);
        map.put("school", school);

        return "admin/school/professionBySchool";


    }

    /**
     * 获取学校下的所有专业
     * @param id
     * @return
     */
    @GetMapping("getPressionBySchool")
    @ResponseBody
    public JsonResult getPressionBySchool(Integer id){

        List<Profession> professions = professionService.findProfessionBySchool(id);
        return JsonResult.ok().set("data", professions);
    }


    /**
     * 获取全部college
     *
     * @param
     * @return
     */
    @GetMapping("/getAll")
    public JsonResult getAll() {
        try {
            List<School> list = schoolService.findAll();
            return JsonResult.ok().set("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 获取全部投递
     *
     * @param id 学院id
     * @return
     */
    @GetMapping("/deliverys")
    public JsonResult findAllDeliverys(Integer id) {
        List<DeliveryRecord> all = deliveryRecordService.findAll();
        List<DeliveryRecord> mine = new ArrayList<>();
        for (DeliveryRecord deliveryRecord : all) {
            if (deliveryRecord.getJob().getCollege().getId() == id) {
                if (deliveryRecord.getStatus() != null) {
                    mine.add(deliveryRecord);
                }
            }
        }
        return JsonResult.ok("获取成功").set("data", mine);
    }

    /**
     * 获取全部投递
     *
     * @param id 学院id
     * @return
     */
    @GetMapping("/deliverys/list")
    @ResponseBody
    public PageJson<DeliveryRecord> all(Integer id, String type) {
        PageRequest pageRequest = getPageRequest();
        List<DeliveryRecord> deliveryRecords = deliveryRecordService.findByStatus(Integer.parseInt(type));
        List<DeliveryRecord> mine = new ArrayList<>();
        if (Integer.parseInt(type) < 2) {
            mine = deliveryRecords;
        } else {
            for (DeliveryRecord deliveryRecord : deliveryRecords) {
                if (deliveryRecord.getJob().getCollege().getId() == id) {
                    if (deliveryRecord.getStatus() != null && deliveryRecord.getStatus() == Integer.parseInt(type)) {
                        mine.add(deliveryRecord);
                    }
                }
            }
        }
        PageJson<DeliveryRecord> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(mine.size());
        page.setData(mine);
        return page;
    }

    @GetMapping("/change/{id}")
    @ResponseBody
    public JsonResult change(@PathVariable("id") Integer id, String type) {
        try {
            deliveryRecordService.changeStatus(id, type);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("修改失败");
        }
        return JsonResult.ok();
    }

    /**
     * 更新投递记录
     *
     * @param deliveryRecord
     * @return
     */
    @GetMapping("/updateDelivery")
    public JsonResult updateDelivery(DeliveryRecord deliveryRecord) {
        try {
            DeliveryRecord delivery = deliveryRecordService.saveOrUpdate(deliveryRecord);
            return JsonResult.ok("更新成功").set("data", delivery);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 更新简历状态为删除
     *
     * @param id
     * @return
     */
    @GetMapping("/updateResume")
    public JsonResult updateResume(Integer id) {
        try {
            DeliveryRecord deliveryRecord = deliveryRecordService.findById(id);
            Resume resume = resumeService.findById(deliveryRecord.getResumeId());
            resume.setStatus(0);
            resumeService.saveOrUpdate(resume);
            deliveryRecord.setStatus(5);
            deliveryRecordService.saveOrUpdate(deliveryRecord);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 添加一条hc
     *
     * @param requirement
     * @return
     */
    @PostMapping("/addHc")
    @ResponseBody
    public JsonResult addHc(Requirement requirement) {
        try {
            Requirement req = requirementService.saveOrUpdate(requirement);
            return JsonResult.ok().set("data", req);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    @GetMapping("/hcList")
    @ResponseBody
    public PageJson<Requirement> hcList(@SessionAttribute("user") School school, ModelMap map) {
        PageRequest pageRequest = getPageRequest();
        Page<Requirement> plans = requirementService.findAll(pageRequest);
        List<Requirement> list = plans.stream().filter(x -> x.getCollege().getId() == school.getId()).collect(Collectors.toList());
        PageJson<Requirement> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(list.size());
        page.setData(list);
        return page;
    }

    @DeleteMapping("/deliverys/{id}")
    public JsonResult del(@PathVariable Integer id) {
        try {
            deliveryRecordService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }
}
