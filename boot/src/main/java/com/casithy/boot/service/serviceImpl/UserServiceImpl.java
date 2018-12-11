package com.casithy.boot.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casithy.boot.database.UserDao;
import com.casithy.boot.model.User;
import com.casithy.boot.service.UserService;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月11日 下午5:07:41
 *
 */
@Service(value="UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int addUser(User user) {
		return userDao.insert(user);
	}

}
 