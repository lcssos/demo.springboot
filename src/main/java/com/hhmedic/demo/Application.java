package com.hhmedic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

/**
 * Created by lcssos on 16/7/6.
 */

//,"classpath*:spring/applicationContext-mybatis.xml"
//    		MybatisAutoConfiguration.class,
@SpringBootApplication(exclude = {
		JmxAutoConfiguration.class,
		SecurityAutoConfiguration.class,
		WebSocketAutoConfiguration.class
})
@EnableScheduling
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//文件下载
	@Bean
	public HttpMessageConverters restFileDownloadSupport() {
		ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
		return new HttpMessageConverters(arrayHttpMessageConverter);
	}

//	@Bean
//	public MultipartResolver commonsMultipartResolver(){
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setDefaultEncoding("utf-8");
//		multipartResolver.setMaxUploadSize(10485760000L);
//		multipartResolver.setMaxInMemorySize(40960);
//		return multipartResolver;
//	}

	//文件上传
//	@Bean
//	public MultipartConfigElement multipartConfigElement() {
//		MultipartConfigFactory factory = new MultipartConfigFactory();
//		factory.setMaxFileSize("1024MB");
//		factory.setMaxRequestSize("1024MB");
//		return factory.createMultipartConfig();
//	}

	// 用于处理编码问题
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}


	@Bean
	public TaskScheduler taskScheduler(){
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		return taskScheduler;
	}

}
