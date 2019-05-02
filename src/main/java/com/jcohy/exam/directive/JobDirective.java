package com.jcohy.exam.directive;

import com.jcohy.exam.model.Job;
import com.jcohy.exam.service.JobService;
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
    private JobService jobService;
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        List<Job> list = jobService.findAllByStatus();
        logger.warn("JobSeeker:{}",list.size());
        environment.setVariable("list", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(list));
        if (templateDirectiveBody != null) {
            templateDirectiveBody.render(environment.getOut());
        }
    }
}
