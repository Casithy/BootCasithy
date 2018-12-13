package com.casithy.boot.config.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import com.casithy.boot.model.User;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月13日 下午3:29:45
 *
 */
public class SecurityUtils {
	/**
	 * 获取身份认证
	 * @return
	 */
	public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
	
	/**
	 * 获取登录中的用户信息
	 * @return
	 */
	public static User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
	
	/**
	 * 获取当前用户的所有权限
	 * @return
	 */
	public static Collection<? extends GrantedAuthority> getAllPermission(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities;
    }
	
	/**
	 * 查询当前用户是否有权限
	 * @param permission
	 * @return
	 */
	public static boolean hasPermission(String permission){
        if(StringUtils.isEmpty(permission)){
            return false;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean hasPermission = false;
        for(GrantedAuthority grantedAuthority : authorities){
            String authority = grantedAuthority.getAuthority();
            if(authority.equals(permission)){
                hasPermission =true;
            }
        }
        return hasPermission;
    }
	
	/**
	 * 登出
	 */
    public static void logout(){
        SecurityContextHolder.clearContext();
    }
}
 