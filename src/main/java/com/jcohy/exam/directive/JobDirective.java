package com.jcohy.exam.directive;

import com.jcohy.exam.model.City;
import com.jcohy.exam.model.Province;
import com.jcohy.exam.model.School;
import com.jcohy.exam.service.CityService;
import com.jcohy.exam.service.ProvinceService;
import com.jcohy.exam.service.SchoolService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by jiac on 2018/5/3.
 * ClassName  : com.jcohy.exam.directive
 * Description  :
 */
@Component
public class JobDirective implements TemplateDirectiveModel{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JobDirective.class);

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        List<School> schools = schoolService.findAll();
        List<Province> provinces = provinceService.findAll();
        List<City> cities = cityService.findByProvince(provinces.get(0));
        logger.warn("School.{}", schools.size());
//        environment.setVariable("list", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(list));
        environment.setVariable("list", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(schools));
        environment.setVariable("provinces", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(provinces));
        environment.setVariable("cities", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(cities));
        if (templateDirectiveBody != null) {
            templateDirectiveBody.render(environment.getOut());
        }
    }
}
