package com.casithy.boot.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.casithy.boot.model.Menu;
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
	public UserDetails loadUserByUsername(String username) {
		User user = userService.loadUserByUserName(username);
		if(null == user) {
			log.error("===== UserName is "+ username +", loadUserByUserName method return null =====");
		}
		
		/*-------------对用户授权--------------*/
		log.info("===== 对username: "+ username +" 授权=====");
		List<Menu> menuList = menuService.loadMenusByUserId(user.getId());
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Menu menu : menuList) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menu.getUrl());
			grantedAuthorities.add(grantedAuthority);
		}
		user.setAuthorities(grantedAuthorities);
		return user;
	}

}
 