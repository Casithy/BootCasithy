package com.casithy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.casithy.boot.model.Menu;
import com.casithy.boot.service.MenuService;
import com.casithy.boot.utils.result.Result;
import com.casithy.boot.utils.result.ResultGenerator;
import com.casithy.boot.utils.service.UuidUtil;
import com.casithy.boot.utils.tree.TreeUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2019年1月14日 上午11:09:08
 *
 */
@Slf4j
@RestController
@RequestMapping(value = "/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping(value="/loadMenuTree/{userId}")
	public Object loadMenuTree(@PathVariable("userId") String userId) {
		Object menuTree = "";
		//获取menus列表
		List<Menu> menus = menuService.loadMenusByUserId(userId);
		//获取menus树菜单
		List<Menu> menuTrees = TreeUtils.getTree(menus);
		
		menuTree = JSONObject.toJSON(menuTrees);
		
		return menuTree;
	}
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request, Menu menu) {
		menu.setId(UuidUtil.getUuid());
		menuService.insert(menu);
		return new ModelAndView("menu");
	}
	
	@RequestMapping(value="/delete/{menuId}")
	public Result delete(@PathVariable("menuId") String menuId) {
		try {
			menuService.delete(menuId);
			return ResultGenerator.genSuccessResult();
		} catch (Exception e) {
			return ResultGenerator.genFailResult("===== 删除菜单失败, 原因: " + e.getMessage() + " =====");
		}
	}
}
 