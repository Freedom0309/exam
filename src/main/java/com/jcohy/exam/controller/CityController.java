package com.jcohy.exam.controller;

import com.jcohy.exam.common.JsonResult;
import com.jcohy.exam.common.PageJson;
import com.jcohy.exam.model.Batch;
import com.jcohy.exam.model.City;
import com.jcohy.exam.model.Province;
import com.jcohy.exam.model.School;
import com.jcohy.exam.service.CityService;
import com.jcohy.exam.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController extends BaseController {

    @Autowired
    private CityService cityService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map) {
        List<Province> provinces = provinceService.findAll();
        map.put("provinces", provinces);
        if (id != null) {
            City city = cityService.findById(id);
            map.put("city", city);
        }
        return "admin/city/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(City city, Integer provinceId) {
        try {
            city.setProvince(provinceService.findById(provinceId));
            cityService.saveOrUpdate(city);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.ok();
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public PageJson<City> all() {
        PageRequest pageRequest = getPageRequest();
        Page<City> cities = cityService.findAll(pageRequest);
        PageJson<City> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(cities.getSize());
        page.setData(cities.getContent());
        return page;
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public JsonResult deleteCity(@PathVariable("id") Integer id) {
        try {
            cityService.deleteById(id);
            return JsonResult.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(City city) {
        try {
            City bth = cityService.saveOrUpdate(city);
            return JsonResult.ok().set("data", bth);
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
    @ResponseBody
    public JsonResult getAll() {
        try {
            List<City> list = cityService.findAll();
            return JsonResult.ok().set("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }

    @GetMapping("/getCity")
    @ResponseBody
    public JsonResult getCityByProvince(Integer provinceId) {
        try {
            List<City> list = new ArrayList<>();
            if (provinceId != null) {
                Province province = provinceService.findById(provinceId);
                list = cityService.findByProvince(province);
            }

            return JsonResult.ok().set("data", list);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
    }
}
