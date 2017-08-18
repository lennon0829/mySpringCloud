/**
 * 
 */
package com.qdynasty.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author fei.qin
 *
 */
@Configuration
@EnableWebSecurity

/**
 * 开启Spring Security 全局方法安全. 
 * prePostEnabled :决定Spring Security的前注解[@PreAuthorize,@PostAuthorize,..]是否可用  
 * secureEnabled : 决定是否Spring Security的保障注解  [@Secured] 是否可用 
 * jsr250Enabled ：决定 JSR-250 annotations 注解[@RolesAllowed..]是否可用.
 */
@EnableGlobalMethodSecurity(prePostEnabled = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 所有请求都需要经过HTTP Basic认证
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerUserDetailsService).passwordEncoder(this.passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		//明文编码器
		return NoOpPasswordEncoder.getInstance();
	}
}
