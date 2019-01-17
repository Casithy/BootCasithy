package com.casithy.boot.utils.tree; 
/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2019年1月14日 下午3:21:04
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicTreeVo<T> {
	private String id;
	
	private String text;
	
	private String parentId;
	
	private List<T> children = new ArrayList<>();
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicTreeVo<?> that = (BasicTreeVo<?>) o;
        return Objects.equals( id, that.id );
    }
	
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<T> getChildren() {
		return children;
	}
	public void setChildren(List<T> children) {
		this.children = children;
	}
}
 