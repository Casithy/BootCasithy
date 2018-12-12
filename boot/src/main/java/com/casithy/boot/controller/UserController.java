package com.casithy.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.casithy.boot.model.User;
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
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/insert")
	public void insert() {
		User user = new User();
		user.setId(UuidUtil.getUuid());
		user.setPassword(TdesUtil.encode3Des(user.getId(), "2134"));
		user.setUsername("14110572101");
		user.setLogged(TimeUtil.getTimeStamp());
		log.info("这就是个测试");
		userService.addUser(user);
	}
}
 