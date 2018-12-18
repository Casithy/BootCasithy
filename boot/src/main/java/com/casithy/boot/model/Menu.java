package com.casithy.boot.model; 
/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午4:08:07
 *
 */
public class Menu {
	
	private String id;
    private String name;
    private String url;
    private String parentId;
    private String level;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
 