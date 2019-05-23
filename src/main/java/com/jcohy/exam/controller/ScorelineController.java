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

import java.util.List;

@Controller
@RequestMapping("/scoreline")
public class ScorelineController extends BaseController {

    @Autowired
    private ScorelineService scorelineService;


    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map) {
        List<Scoreline> scorelines = scorelineService.findAll();
        map.put("scorelines", scorelines);
        if (id != null) {
            Scoreline scoreline = scorelineService.findById(id);
            map.put("scoreline", scoreline);
        }
        return "admin/scoreline/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Scoreline scoreline) {
        try {
            scorelineService.saveOrUpdate(scoreline);
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
    public PageJson<Scoreline> all() {
        PageRequest pageRequest = getPageRequest();
        Page<Scoreline> scorelines = scorelineService.findAll(pageRequest);
        PageJson<Scoreline> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(((int) scorelines.getTotalElements()));
        page.setData(scorelines.getContent());
        return page;
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteScoreline(@PathVariable("id") Integer id) {
        try {
            scorelineService.delete(id);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 更新学院信息
     *
     * @param scoreline
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Scoreline scoreline) {
        try {
            Scoreline sch = scorelineService.saveOrUpdate(scoreline);
            return JsonResult.ok().set("data", sch);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 获取全部的数据
     *
     * @param
     * @return
     */
    @GetMapping("/getAll")
    public JsonResult getAll() {
        try {
            List<Scoreline> list = scorelineService.findAll();
            return JsonResult.ok().set("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

}
