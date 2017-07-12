package com.hhmedic.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by lcssos on 16/7/15.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations("/");
//	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("redirect:/index");
//	}

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(responseBodyConverter());
	}

}
