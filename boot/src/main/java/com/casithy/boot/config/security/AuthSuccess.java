package com.casithy.boot.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月23日 下午8:55:38
 *
 */
@Slf4j
public class AuthSuccess implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("===== login success , AuthenticationSuccessHandler forward =====");
		request.getRequestDispatcher("/index").forward(request, response);
	}

}
 