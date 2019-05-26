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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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


    @RequestMapping("/list")
    @ResponseBody
    public PageJson<City> findAll() {

        //分页查询，从第0页开始查找
        PageRequest pageRequest = getPageRequest();
        Page<City> cityList = cityService.findAll(pageRequest);

        Iterator<City> iterator = cityList.iterator();
        while(iterator.hasNext()){
            City city = iterator.next();
            city.setProvinceName(city.getProvince().getName());
        }
        //返回给前台的数据格式
        PageJson<City> pages = new PageJson<>();
        pages.setCode(0);
        pages.setMsg("成功");
        pages.setCount((int)cityList.getTotalElements());
        pages.setData(cityList.getContent());
        return pages;
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
