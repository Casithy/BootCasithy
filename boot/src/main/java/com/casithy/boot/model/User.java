package com.casithy.boot.model;

import java.io.Serializable;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年11月5日 上午9:53:18
 *
 */

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	/**
	 * 登录名
	 */
	private String username;
	
	/**
	 * 登录密码
	 */
	private String password;
	
    /**
     * 上次登录最后活跃时间
     */
    private Integer logged;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLogged() {
		return logged;
	}

	public void setLogged(Integer logged) {
		this.logged = logged;
	}
}
 