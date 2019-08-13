package com.eatia;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>
 * Title: WebConfig.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright(c) Ehab Kamil, 2019
 * </p>
 *
 * @author <a href="mailto:ehab.atia@ITWorx">Ehab Attia</a>
 * @version 1.0
 * @date 13/08/2019
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**", "/fonts/**", "/images/**", "/js/**", "/vendor/**")
				.addResourceLocations("classpath:/static/css/", "classpath:/static/fonts/", "classpath:/static/images/",
						"classpath:/static/js/","classpath:/static/vendor/" );

	}
}
