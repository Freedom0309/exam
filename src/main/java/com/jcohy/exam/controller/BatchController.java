package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.model.Batch;
import com.jcohy.exam.model.School;
import com.jcohy.exam.service.BatchService;
import com.jcohy.exam.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/batch")
public class BatchController extends BaseController {

    @Autowired
    private BatchService batchService;

    @Autowired
    private SchoolService schoolService;


    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map) {
        List<School> schools = schoolService.findAll();
        map.put("schools", schools);
        if (id != null) {
            Batch batch = batchService.findById(id);
            map.put("batch", batch);
        }
        return "admin/batch/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Batch batch, Integer schoolId) {
        try {
            batch.setSchool(schoolService.findById(schoolId));
            batchService.saveOrUpdate(batch);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.ok();
    }

    /**
     * 查询所有批次
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public PageJson<Batch> all(HttpServletRequest request) {

        String pa = request.getParameter("page");
        String limit = request.getParameter("limit");
        PageRequest pageRequest = PageRequest.of(Integer.valueOf(pa) -1,
                Integer.valueOf(limit));

        Page<Batch> batches = batchService.findAll(pageRequest);
        Iterator<Batch> iterator = batches.iterator();
        while (iterator.hasNext()){
            Batch batch = iterator.next();
            batch.setSchoolName(batch.getSchool().getName());
        }
        PageJson<Batch> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(((int) batches.getTotalElements()));
        page.setData(batches.getContent());
        return page;
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteBatch(@PathVariable("id") Integer id) {
        try {
            batchService.delete(id);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 更新批次信息
     *
     * @param batch
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Batch batch) {
        try {
            Batch sch = batchService.saveOrUpdate(batch);
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
            List<Batch> list = batchService.findAll();
            return JsonResult.ok().set("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

}
