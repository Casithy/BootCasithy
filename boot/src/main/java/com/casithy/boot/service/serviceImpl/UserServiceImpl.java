package com.casithy.boot.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casithy.boot.database.UserMapper;
import com.casithy.boot.model.User;
import com.casithy.boot.service.UserService;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月11日 下午5:07:41
 *
 */
@Slf4j
@Service(value="UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}

	@Override
	public User loadUserByUserName(String userName) {
		log.info("===== start loadUserByUserName method =====");
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andCondition("username = '" + userName +"'");
		List<User> userList = userMapper.selectByExample(example);
		if(null == userList || userList.isEmpty()) {
			log.error("===== UserName is "+ userName +", loadUserByUserName method return null =====");
			return null;
		}
		else {
			return userList.get(0);
		}
	}

	@Override
	public List<User> loadUserlist(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return userMapper.selectAll();
	}
	
}
 