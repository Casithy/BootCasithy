package com.casithy.boot.database;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.casithy.boot.database.mapper.BaseMapper;
import com.casithy.boot.model.User;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月11日 下午5:19:29
 *
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User>{
}
 