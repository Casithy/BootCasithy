package com.casithy.boot.Index.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casithy.boot.Unite.result.Result;
import com.casithy.boot.Unite.result.ResultGenerator;

/**
 * 
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年11月1日 上午11:36:52
 *
 */
@RestController
public class IndexController {
	
	@GetMapping("/index")
	public Result index() {
		return ResultGenerator.genSuccessResult("Hello World!");
	}
	
}
 