package com.casithy.boot.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casithy.boot.config.security.SecurityUtils;

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
	public String index(Map<String, Object> map) {
		return "index";
	}
	
	@RequestMapping(value="/login")
    public String login()  {
        return "login";
    }
	
	@RequestMapping("/404")
    public String to404()  {
        return "/error/404";
    }
	
    @RequestMapping("/403")
    public String to403()  {
        return "/error/403";
    }
    
    @RequestMapping("/500")
    public String to500()  {
        return "/error/500";
    }
    @RequestMapping("/login-error")
    public String loginError(Model model,HttpSession session) {
    	model.addAttribute("result", "error");
    	return "login";
    }
    
    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.logout();
        return "login";
    }
    
    @RequestMapping(value = "/menu")
    public String menu() {
    	return "menu";
    }
}
 