package com.casithy.boot.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.casithy.boot.model.User;
import com.casithy.boot.service.UserService;
import com.casithy.boot.utils.result.Result;
import com.casithy.boot.utils.result.ResultGenerator;
import com.casithy.boot.utils.service.ConstantVal;
import com.casithy.boot.utils.service.RedisUtil;
import com.casithy.boot.utils.service.TdesUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月14日 下午2:18:59
 *
 */
@RestController
public class LoginController {
	@Autowired
    DefaultKaptcha defaultKaptcha;
	
	@Autowired
	private AuthenticationManager BootAuthenticationManager;
	
	@Autowired
	private UserService userService;
	 
	@RequestMapping(value = "/userLogin")
    public Result userLogin(HttpServletRequest request) {

        User userInfo = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String kaptcha = request.getParameter("logincode");

        userInfo.setUsername(username);
        userInfo.setPassword(password);
        String inputCode = request.getSession().getAttribute(ConstantVal.CHECK_CODE).toString();
        
        if(null == inputCode) {
        	return ResultGenerator.genFailResult("验证码失效，请刷新重试.");
        }
        
        if (StringUtils.isEmpty(kaptcha) || !inputCode.equals(kaptcha)) {
            return ResultGenerator.genFailResult("请输入正确的验证码.");
        }
        
        User user = userService.loadUserByUserName(username);
        
        if(null == user) {
        	return ResultGenerator.genFailResult("登录失败，用户名或密码错误.");
        }
        
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken 
        									= new UsernamePasswordAuthenticationToken(username, 
        											TdesUtil.encode3Des(user.getId(), password));
        
        try{
            //使用SpringSecurity拦截登陆请求 进行认证和授权
            Authentication authenticate = BootAuthenticationManager.authenticate(usernamePasswordAuthenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authenticate);
            //使用redis session共享
            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
        }catch (BadCredentialsException e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("登录失败，用户名或密码错误.");
        }
        catch (Exception e) {
        	e.printStackTrace();
            return ResultGenerator.genFailResult("系统错误，请联系管理员查看日志.");
		}
        return ResultGenerator.genSuccessResult("登录成功");
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
 