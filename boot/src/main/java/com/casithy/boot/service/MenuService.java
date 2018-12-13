package com.casithy.boot.service;

import java.util.List;

import com.casithy.boot.model.Menu;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午4:11:19
 *
 */
public interface MenuService {

	List<Menu> loadMenusByUserId(String userId);

}
 