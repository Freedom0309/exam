package com.jcohy.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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



		registry.addViewController("/admin/school/index").setViewName("/admin/school/index");

		registry.addViewController("/admin/profession/index").setViewName("/admin/profession/index");

		registry.addViewController("/admin/scoreline/index").setViewName("/admin/scoreline/index");

		registry.addViewController("/admin/batch/index").setViewName("/admin/batch/index");

		registry.addViewController("/admin/schoolline/index").setViewName("/admin/schoolline/index");
		registry.addViewController("/admin/city/index").setViewName("/admin/city/index");
		registry.addViewController("/admin/province/index").setViewName("/admin/province/index");

		registry.addViewController("/school/recommend").setViewName("/front/recommend");



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
