package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.enums.ArtsScience;
import com.jcohy.exam.model.Profession;
import com.jcohy.exam.model.School;
import com.jcohy.exam.model.SchoolLine;
import com.jcohy.exam.service.ProfessionService;
import com.jcohy.exam.service.SchoolLineService;
import com.jcohy.exam.service.SchoolProfessionService;
import com.jcohy.exam.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/schoolline")
public class SchoolLineController extends BaseController {


    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolProfessionService schoolProfessionService;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private SchoolLineService schoolLineService;


    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map) {
        List<School> schools = schoolService.findAll();
        List<Profession> professions = new ArrayList<>();

        map.put("schools", schools);
        map.put("arts", ArtsScience.getList());

        if (id != null) {
            SchoolLine schoolLine = schoolLineService.findById(id);
            map.put("schoolLine", schoolLine);
            List<Object[]> professions1 = schoolProfessionService.findProfessionBySchool(schoolLine.getSchool().getId());

            if (professions1.size() > 0) {
                for (Object[] obj : professions1) {
                    Profession profession = new Profession();
                    profession.setId(Integer.valueOf(obj[0].toString()));
                    profession.setName(obj[1].toString());
                    professions.add(profession);
                }
            }
            map.put("professions", professions);

        }
        return "admin/schoolline/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(SchoolLine schoolLine, Integer schoolId, Integer professionId) {
        try {
            schoolLine.setSchool(schoolService.findById(schoolId));
            schoolLine.setProfession(professionService.findById(professionId));
            schoolLineService.saveOrUpdate(schoolLine);
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
    public PageJson<SchoolLine> all() {
        PageRequest pageRequest = getPageRequest();
        List<SchoolLine> schoolLines = new ArrayList<>();
        List<Object[]> objs = schoolLineService.
                findAllSchoolLine(pageRequest.getPageNumber() * pageRequest.getPageSize(),
                        pageRequest.getPageSize());
        if(objs.size() > 0){
            for (Object[] obj : objs) {
                SchoolLine schoolLine = new SchoolLine();
                schoolLine.setId(Integer.valueOf(obj[0].toString()));
                schoolLine.setSchoolName(obj[1].toString());
                schoolLine.setSchoolLine(Integer.valueOf(obj[2].toString()));
                schoolLine.setArtsScience(obj[3].toString());
                schoolLine.setProfessionName(obj[4].toString());
                schoolLines.add(schoolLine);
            }
        }
        PageJson<SchoolLine> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(((int) schoolLineService.count()));
        page.setData(schoolLines);
        return page;
    }

    /**
     * 删除学校以及学校的专业
     *
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteSchoolLine(@PathVariable("id") Integer id) {
        try {
            schoolLineService.delete(id);

            return JsonResult.ok("删除成功");
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
    public JsonResult saveSchoolLine(@RequestParam("ids") String ids, Integer schoolId) {

        return JsonResult.ok();
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
}
