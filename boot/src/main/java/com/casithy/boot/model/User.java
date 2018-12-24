package com.casithy.boot.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年11月5日 上午9:53:18
 *
 */

public class User implements UserDetails,Serializable{

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
    private String logged;
    
    /**
     * 权限列表
     */
    private List<? extends GrantedAuthority> authorities;
    
    /**
     * 菜单列表
     * @return
     */
    private List<Menu> menus;
    
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

	public String getLogged() {
		return logged;
	}

	public void setLogged(String logged) {
		this.logged = logged;
	}
	
	public void setAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}
 