package com.casithy.boot.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.casithy.boot.utils.result.Result;
import com.casithy.boot.utils.service.ConstantVal;
import com.google.code.kaptcha.impl.DefaultKaptcha;


/**
 * 
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年11月1日 上午11:36:52
 *
 */
@Controller
public class IndexController {
	
	@Autowired
    DefaultKaptcha defaultKaptcha;
	
	@RequestMapping("/index")
	public  String index() {
		return "index";
	}
	
	@RequestMapping(value="/login")
    public String login()  {
        return "login";
    }
	
	@RequestMapping("/captcha.jpg")
    @ResponseBody
    public void applyCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = defaultKaptcha.createText();
        //生成图片验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        //保存到session
        request.getSession().setAttribute(ConstantVal.CHECK_CODE, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }
}
 