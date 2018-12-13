package com.casithy.boot.database;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.casithy.boot.model.Menu;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午4:10:44
 *
 */
@Mapper
@Component
public interface MenuMapper {

	List<Menu> loadMenusByUserId(String userId);

}
 