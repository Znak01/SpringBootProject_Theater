package ua.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		    .userDetailsService(this.userDetailsService)
		    .passwordEncoder(passwordEncoder());
		
//		auth
//		     .inMemoryAuthentication()
//		     .withUser("admin@gmail.com")
//		     .password("123")
//		     .roles("ADMIN")
//		   .and()
//		      .withUser("user@gmail.com")
//		      .password("123")
//		      .roles("USER");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .formLogin()
		    .usernameParameter("email")
		    .passwordParameter("password")
		    .loginPage("/login")//.successHandler(new CustomAuthentificationSuccessHandler())
		    .failureUrl("/login?fail=true")
		  .and()
		     .logout()
		     .logoutUrl("/logout")
		     .logoutSuccessUrl("/")
		     .deleteCookies("COKID", "RememberMeCookie")
		     .invalidateHttpSession(true)
		   .and()
		        .authorizeRequests()
		        .antMatchers("/admin/**").hasRole("ADMIN")
		        .antMatchers("/visitor/**").hasAnyRole("ADMIN", "USER")
		        .anyRequest().permitAll()
		   .and()
		        .exceptionHandling().accessDeniedPage("/")
		   .and()
		        .sessionManagement().maximumSessions(1)
		   .and().and()
		        .rememberMe()
		        .rememberMeParameter("rememberme")
		        .key("secret key")
		        .rememberMeCookieName("RememberMeCookie")
		        .tokenValiditySeconds(365 * 24 * 60 * 60);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	
	
}
