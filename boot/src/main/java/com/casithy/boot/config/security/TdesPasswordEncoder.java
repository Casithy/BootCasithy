package com.casithy.boot.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月13日 下午4:04:07
 *
 */
public class TdesPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(rawPassword);
	}
}
 