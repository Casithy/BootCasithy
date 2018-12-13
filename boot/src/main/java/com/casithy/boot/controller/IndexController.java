package com.casithy.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年11月1日 上午11:36:52
 *
 */
@Controller
public class IndexController {
	
	
	@RequestMapping("/index")
	public  String index() {
		return "index";
	}
	
	@RequestMapping(value="/login")
    public String login()  {
        return "login";
    }
	
}
 