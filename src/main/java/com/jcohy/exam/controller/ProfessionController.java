package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.model.*;
import com.jcohy.exam.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/profession")
public class ProfessionController extends BaseController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private SchoolProfessionService schoolProfessionService;


    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map) {
        List<Profession> professions = professionService.findAll();
        map.put("professions", professions);
        if (id != null) {
            Profession profession = professionService.findById(id);
            map.put("profession", profession);
        }
        return "admin/profession/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Profession profession) {
        try {
            professionService.saveOrUpdate(profession);
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
    public PageJson<Profession> all() {
        //        List<> list = plans.stream().filter(x -> x.getCollege().getId() == Profession.getId()).collect(Collectors.toList());
        PageRequest pageRequest = getPageRequest();
        Page<Profession> professions = professionService.findAll(pageRequest);
        PageJson<Profession> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(((int) professions.getTotalElements()));
        page.setData(professions.getContent());
        return page;
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteProfession(@PathVariable("id") Integer id) {
        try {
            professionService.delete(id);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }


    /**
     * 更新学院信息
     *
     * @param profession
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Profession profession) {
        try {
            Profession sch = professionService.saveOrUpdate(profession);
            return JsonResult.ok().set("data", sch);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
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
            List<Profession> list = professionService.findAll();
            return JsonResult.ok().set("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 根据名称搜索专业
     * @param proName
     * @return
     */
    @GetMapping("/searchProfession")
    @ResponseBody
    public JsonResult findProfession(String proName) {
        List lists = new ArrayList();
        List<Profession> professions = professionService.findByNameIsLike("%" + proName + "%");
        List<SchoolProfession> sps = schoolProfessionService.findAll();
        if (sps.size() > 0) {
            for (Profession pro : professions) {
                for (SchoolProfession sp : sps) {
                    List<Object> list = new ArrayList<>();
                    if(pro.getId() == sp.getProfessionId()){
                        list.add(schoolService.findById(sp.getSchoolId()));
                        list.add(pro);
                        lists.add(list);
                    }
                }
            }
        }
//        return JsonResult.ok().set("data", lists);
        return JsonResult.ok().set("data", professions);
    }

    @GetMapping("/recommendProfession")
    @ResponseBody
    public JsonResult findProfession(String city, String arts, Integer score, Integer grade) {
        List lists = new ArrayList();
        List<Object[]> obj = professionService.findProfession(city, arts, score);

        return JsonResult.ok().set("data", obj);
    }


}
