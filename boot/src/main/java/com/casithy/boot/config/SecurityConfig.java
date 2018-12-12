package com.casithy.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 上午11:37:34
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers( "/favicon.ico","/css/**","/common/**","/js/**","/images/**","/captcha.jpg","/login","/userLogin","/login-error").permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successForwardUrl("/index").failureForwardUrl("/login?error=1")
                .and()
                //权限拒绝的页面
                .exceptionHandling().accessDeniedPage("/403");
 
        http.logout().logoutSuccessUrl("/login");
    }
	
}
 