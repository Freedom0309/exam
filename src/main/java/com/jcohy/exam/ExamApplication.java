package com.jcohy.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class ExamApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("st")
	}*/

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		//前台首页
		registry.addViewController("/").setViewName("front/index");


		//管理员主页，从登录
		registry.addViewController("/admin").setViewName("/login");


		//管理员主页，从登录
		registry.addViewController("/admin/main").setViewName("/admin/main");


		registry.addViewController("/admin/lab/index").setViewName("/admin/lab/index");

		registry.addViewController("/admin/plan/index").setViewName("/admin/plan/index");

		registry.addViewController("/admin/college/index").setViewName("/admin/college/index");

		registry.addViewController("/admin/addcollege/index").setViewName("/admin/addcollege/index");

		registry.addViewController("/admin/managereq/index").setViewName("/admin/managereq/index");

		registry.addViewController("/admin/job/index").setViewName("/admin/job/index");

		registry.addViewController("/admin/check/index").setViewName("/admin/check/index");

		registry.addViewController("/admin/school/index").setViewName("/admin/school/index");

		registry.addViewController("/admin/profession/index").setViewName("/admin/profession/index");

		registry.addViewController("/admin/scoreline/index").setViewName("/admin/scoreline/index");

		registry.addViewController("/admin/batch/index").setViewName("/admin/batch/index");

		registry.addViewController("/college/addreq/index").setViewName("/college/addreq/index");

		registry.addViewController("/college/managereq/index").setViewName("/college/managereq/index");

		registry.addViewController("/college/shenhe/index").setViewName("/college/shenhe/index");


		//学院主页，从登录
		registry.addViewController("/college/main").setViewName("/college/main");

		registry.addViewController("/user/login").setViewName("front/login");

		registry.addViewController("/user/register").setViewName("front/register");

		registry.addViewController("/user/index").setViewName("front/user");
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大
		factory.setMaxFileSize("102400KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}
}
