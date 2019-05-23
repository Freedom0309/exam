package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.model.City;
import com.jcohy.exam.model.Province;
import com.jcohy.exam.service.CityService;
import com.jcohy.exam.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/province")
public  class ProvinceController extends BaseController{

    @Autowired
    private CityService cityService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map) {
        if (id != null) {
            Province province = provinceService.findById(id);
            map.put("province", province);
        }
        return "admin/province/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Province province) {
        try {
            provinceService.saveOrUpdate(province);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.ok();
    }



    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteCity(@PathVariable("id") Integer id) {
        try {
            provinceService.deleteById(id);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 更新城市信息
     *
     * @param province
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Province province) {
        try {
            Province bth = provinceService.saveOrUpdate(province);
            return JsonResult.ok().set("data", bth);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Province> all() {
        PageRequest pageRequest = getPageRequest();
        Page<Province> provinces = provinceService.findAll(pageRequest);
        PageJson<Province> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(((int) provinces.getTotalElements()));
        page.setData(provinces.getContent());
        return page;
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
            List<Province> list = provinceService.findAll();
            return JsonResult.ok().set("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }
}
