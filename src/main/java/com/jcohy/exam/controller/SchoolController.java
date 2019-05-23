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
@RequestMapping("/school")
public class SchoolController extends BaseController {


    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolProfessionService schoolProfessionService;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private BatchService batchService;


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
        page.setCount(((int) schools.getTotalElements()));
        page.setData(schools.getContent());
        return page;
    }

    /**
     * 删除学校以及学校的专业
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteSchool(@PathVariable("id") Integer id) {
        try {
            schoolProfessionService.deleteBySchoolId(id);
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
     *
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/profession")
    public String getAllProfession(@RequestParam(required = true) Integer id, ModelMap map) {

        School school = schoolService.findById(id);
        map.put("school", school);

        return "admin/school/profession";
    }


    /**
     * 给学校下新增专业
     *
     * @param ids
     * @param schoolId
     * @return
     */
    @PostMapping("/saveProfession")
    @ResponseBody
    public JsonResult saveProfession(@RequestParam("ids") String ids, Integer schoolId) {

        List<SchoolProfession> professions = getSchoolProfessions(ids, schoolId);
        schoolProfessionService.batchSave(professions);

        return JsonResult.ok();
    }

    private List<SchoolProfession> getSchoolProfessions(String ids, Integer schoolId) {
        ids = ids.substring(1, ids.length() - 1);
        List<SchoolProfession> professions = new ArrayList<>();
        String[] strs = ids.split(",");
        for (int i = 0; i < strs.length; i++) {
            SchoolProfession schoolProfession = new SchoolProfession();
            schoolProfession.setProfessionId(Integer.valueOf(strs[i]));
            schoolProfession.setSchoolId(schoolId);
            professions.add(schoolProfession);
        }
        return professions;
    }

    /**
     * 删除学校的专业
     *
     * @param ids
     * @param schoolId
     * @return
     */
    @PostMapping("/deleteProfession")
    @ResponseBody
    public JsonResult deleteProfession(@RequestParam("ids") String ids, Integer schoolId) {

        try {
            ids = ids.substring(1, ids.length() - 1);
            List<SchoolProfession> professions = new ArrayList<>();
            String[] strs = ids.split(",");
            //找到要删除的对象
            for (int i = 0; i < strs.length; i++) {
                professions.add(schoolProfessionService.findBySchoolIdAndProfessionId(schoolId, Integer.valueOf(strs[i])));
            }

            schoolProfessionService.deleteInBatch(professions);
            return JsonResult.ok("删除成功");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }

    }



    /**
     * 学校中已有的专业页面
     *
     * @param id 学校id
     * @return
     */
    @GetMapping("pressionBySchool")
    public String pressionBySchool(@RequestParam(required = true) Integer id, ModelMap map) {

        School school = schoolService.findById(id);
        map.put("school", school);

        return "admin/school/professionBySchool";


    }

    /**
     * 获取学校下的所有专业
     *
     * @param id
     * @return
     */
    @GetMapping("getPressionBySchool")
    @ResponseBody
    public PageJson<Profession> getPressionBySchool(Integer id) {

        PageJson page = new PageJson();

        List<Profession> professions = new ArrayList<>();
        List<Object[]> professions1 = schoolProfessionService.findProfessionBySchool(id);

        if (professions1.size() > 0) {
            for (Object[] obj : professions1) {
                Profession profession = new Profession();
                profession.setId(Integer.valueOf(obj[0].toString()));
                profession.setName(obj[1].toString());
                profession.setDescription(obj[2].toString());
                profession.setFuture(obj[3].toString());
                profession.setCompensation(Integer.valueOf(obj[4].toString()));
                professions.add(profession);
            }
        }

        page.setCode(0);
        page.setMsg("成功");
        page.setCount(professions.size());
        page.setData(professions);
        return page;
    }

    /**
     * 获取学校下的没有的专业
     *
     * @param id
     * @return
     */
    @GetMapping("getPressionNotInSchool")
    @ResponseBody
    public PageJson<Profession> getPressionNotInSchool(Integer id) {

        PageJson page = new PageJson();
        PageRequest pageRequest = getPageRequest();
        List<Profession> professions = professionService.findAll();
        List<SchoolProfession> schoolProfessions = schoolProfessionService.findBySchoolId(id);
        Map<Integer, Profession> proMap = new LinkedHashMap<>();
        for (Profession pro : professions) {
            proMap.put(pro.getId(), pro);
        }

        //找到学校中已有的专业加入list中
        List<Profession> temp = new ArrayList<>();
        for (SchoolProfession sp : schoolProfessions) {
            for (Map.Entry<Integer, Profession> entry : proMap.entrySet()) {
                if (entry.getKey() == sp.getProfessionId()) {
                    temp.add(entry.getValue());
                    continue;
                }
            }
        }
        //移除学校已有的专业
        professions.removeAll(temp);

        page.setCode(0);
        page.setMsg("成功");
        page.setCount(professions.size());
        page.setData(professions);
        return page;
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
     * 查询具体的学校信息
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/detail/{id}")
    public String schoolDetail(@PathVariable Integer id, ModelMap map){
        School school = schoolService.findById(id);
        List<Batch> batches = batchService.findBySchool(school);
        map.put("school", school);
        map.put("batches", batches);
        return "front/detail";
    }

    @ResponseBody
    @GetMapping("/searchSchool")
    public JsonResult searchSchool(String key){
        List<School> schools = schoolService.findByNameLike("%" + key + "%");
        return JsonResult.ok().set("data", schools);
    }
}
