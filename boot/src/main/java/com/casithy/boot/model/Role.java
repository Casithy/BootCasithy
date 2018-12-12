package com.casithy.boot.model; 
/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午4:21:52
 *
 */

public class Role {
	
	private String id;
	
	private String roleName;
	
	private String creatTime;
	
	private String modifiedTime;
	
	private int status;
	
	private int isDel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
}
 