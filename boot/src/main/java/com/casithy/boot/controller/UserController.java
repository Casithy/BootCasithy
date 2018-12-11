package com.casithy.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.casithy.boot.model.User;
import com.casithy.boot.service.UserService;
import com.casithy.boot.utils.service.Uuid;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月11日 下午5:15:03
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/insert")
	public void insert() {
		User user = new User();
		user.setId(Uuid.getUuid());
		user.setPassword("2134");
		user.setUsername("14110572101");
		user.setLogged(1);
		userService.addUser(user);
	}
}
 