package ua.springboot.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}

	// UTF-8
		@Bean
		public FilterRegistrationBean filterRegistrationBean() {
			FilterRegistrationBean registrationBean = new FilterRegistrationBean();
			CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
			characterEncodingFilter.setForceEncoding(true);
			characterEncodingFilter.setEncoding("UTF-8");
			registrationBean.setFilter(characterEncodingFilter);
			return registrationBean;
		}
	
//		@Override
//		public void addFormatters(FormatterRegistry registry) {
//			registry.addFormatter(new UserFormatter());
//		}

}
