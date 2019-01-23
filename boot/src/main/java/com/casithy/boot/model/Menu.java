package com.casithy.boot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Id;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午4:08:07
 *
 */
public class Menu {
	
	@Id
	private String id;
    private String text;
    private String href;
    private String parentId;
    private String level;
    private String sortNo;
    
    private List<String> tags = new ArrayList<>();
    private List<Menu> nodes = new ArrayList<>();
    
    HashMap<String, Boolean> state = new HashMap<String, Boolean>() {
		{
			put("selected", false);
			put("expanded", false);
		}
	};
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
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

	public List<Menu> getNodes() {
		return nodes;
	}

	public void setNodes(List<Menu> nodes) {
		this.nodes = nodes;
	}

	public HashMap<String, Boolean> getState() {
		return state;
	}

	public void setState(HashMap<String, Boolean> state) {
		this.state = state;
	}

	public String getSortNo() {
		return sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
 