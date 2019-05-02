package com.jcohy.exam.common;

import com.jcohy.exam.directive.JobDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;
    

    @Autowired
    private JobDirective jobDirective;
    @PostConstruct
    public void setSharedVariable() {
    	try {
			configuration.setSharedVariable("jobList", jobDirective);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
