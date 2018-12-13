package com.casithy.boot.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casithy.boot.database.MenuMapper;
import com.casithy.boot.model.Menu;
import com.casithy.boot.service.MenuService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午4:11:32
 *
 */
@Slf4j
@Service(value="MenuService")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> loadMenusByUserId(String userId) {
		return menuMapper.loadMenusByUserId(userId);
	}

}
 