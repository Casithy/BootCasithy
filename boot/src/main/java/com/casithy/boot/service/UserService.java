package com.casithy.boot.service;


import java.util.List;

import com.casithy.boot.model.User;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月11日 下午5:07:16
 *
 */
public interface UserService{
	int addUser(User user);
	
	User loadUserByUserName(String userName);
	
	List<User> loadUserlist(int pageNum, int pageSize);
}
 