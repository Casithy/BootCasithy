package com.casithy.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.casithy.boot.config.security.SecurityUtils;
import com.casithy.boot.model.User;
import com.casithy.boot.service.MenuService;
import com.casithy.boot.service.UserService;
import com.casithy.boot.utils.service.TdesUtil;
import com.casithy.boot.utils.service.TimeUtil;
import com.casithy.boot.utils.service.UuidUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月11日 下午5:15:03
 *
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/loginUserInfo")
	public User loginUserInfo() {
		User user = SecurityUtils.getUser();
		if(null != user) {
			user.setMenus(menuService.loadMenusByUserId(user.getId()));
		}
		user.setPassword("");
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="/insert")
	public int insert(User user) {
		user.setId(UuidUtil.getUuid());
		user.setPassword(TdesUtil.encode3Des(user.getId(), user.getPassword()));
		user.setLogged(TimeUtil.getTimeStamp());
		log.info("===== insert user table , id: "+ user.getId() +", username: "+ user.getUsername() +" =====");
		return userService.addUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/loadUserlist/{pageNum}/{pageSize}")
	public List<User> loadUserlist(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
		return userService.loadUserlist(pageNum, pageSize);
	}
}
 