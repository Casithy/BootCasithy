package com.casithy.boot.utils.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.casithy.boot.model.Menu;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2019年1月14日 下午3:24:58
 *
 */
public class TreeUtils {
	public static List<Menu> getTree(List<Menu> sources){
        List<Menu> rootList =  getTreeRoot(sources);
        int len = rootList.size();
        for(int i = 0; i < len; i++){
        	rootList.get(i).getState().put("selected", true);
        	rootList.get(i).getState().put("expanded", true);
        	rootList.get(i).getTags().add(rootList.get(i).getSortNo());
            getTreeChildNode(sources, rootList.get(i));
        }
        return rootList;
    }

    /**
     * 分离出根节点
     * @return
     */
    private static List<Menu> getTreeRoot(List<Menu> sources){
        List<Menu> rootList = new ArrayList<>();
        for(Menu menu : sources) {
        	if(menu.getParentId().equals("")) {
        		rootList.add(menu);
        	}
        }
        return rootList;
    }


    /**
     * 分离出子节点
     * @return
     */
    private static void getTreeChildNode(List<Menu> sources,Menu parentNode){
    	for(Menu menu: sources) {
    		if(menu.getParentId().equals(parentNode.getId())) {
    			menu.getTags().add(menu.getSortNo());
    			parentNode.getNodes().add(menu);
    			getTreeChildNode(sources, menu);
    		}
    	}
    }
}
 