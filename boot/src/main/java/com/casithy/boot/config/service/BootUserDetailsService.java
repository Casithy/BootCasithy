package com.casithy.boot.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.casithy.boot.model.User;
import com.casithy.boot.service.MenuService;
import com.casithy.boot.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午3:41:16
 *
 */
@Slf4j
public class BootUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.loadUserByUserName(username);
		if(null == user) {
			log.error("===== UserName is "+ username +", loadUserByUserName method return null =====");
		}
		
		
		
		return user;
	}

}
 