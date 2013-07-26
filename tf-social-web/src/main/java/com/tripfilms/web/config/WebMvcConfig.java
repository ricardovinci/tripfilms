package com.tripfilms.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.tripfilms.core.config.DbConfig;
import com.tripfilms.web.social.bo.UserInterceptorBO;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tripfilms")
@PropertySource(value="classpath:com/tripfilms/web/config/application.properties")
@Import({DbConfig.class, SocialConfig.class})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private UsersConnectionRepository usersConnectionRepository;
	
	public void addInterceptors(InterceptorRegistry pRegistry) {
		pRegistry.addInterceptor(new UserInterceptorBO(usersConnectionRepository));
	}

	public void addViewControllers(ViewControllerRegistry pRegistry) {
		pRegistry.addViewController("/signin");
		pRegistry.addViewController("/signout");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver oViewResolver = new InternalResourceViewResolver();
		oViewResolver.setPrefix("/WEB-INF/views/");
		oViewResolver.setSuffix(".jsp");
		return oViewResolver;
	}

}
