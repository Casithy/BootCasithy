package com.casithy.boot.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	
	@Autowired
	AuthSuccess authsuccess;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }
	
	private PasswordEncoder passwordEncoder() {
		return new TdesPasswordEncoder();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests()
//							  //公共资源列表 
//							 .antMatchers("/css/**","/error/**","/fonts/**","/img/**","/js/**").permitAll()
//							  //权限认证列表
////							 .antMatchers("/admin/**","/upload/**").hasAnyRole("ADMIN")
////				             .antMatchers("/order/**").hasAnyRole("USER","ADMIN")
////				             .antMatchers("/room/**").hasAnyRole("USER","ADMIN")
//							 .anyRequest().authenticated().and().formLogin()
//							 .loginPage("/login").successForwardUrl("/index").failureForwardUrl("/login")
//							 .and().exceptionHandling().accessDeniedPage("/403");
							 
							 
        http.authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers("/css/**",
                			 "/error/**",
                			 "/js/**",
                			 "/img/**",
                			 "/fonts/**",
                			 "/index",
                			 "/login",
                			 "/captcha.jpg",
                			 "/userLogin")
                .permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(authsuccess).failureForwardUrl("/login")
                .and()
                //权限拒绝的页面
                .exceptionHandling().accessDeniedPage("/403");
        http.headers().frameOptions().sameOrigin();
        http.logout().logoutSuccessUrl("/login");
    }
	
	/**
     * 自定义UserDetailsService，授权
     * @return
     */
    @Bean
    public BootUserDetailsService customUserDetailsService(){
        return new BootUserDetailsService();
    }
	
    /**
     * AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
 