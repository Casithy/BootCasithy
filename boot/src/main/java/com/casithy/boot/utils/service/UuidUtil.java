package com.casithy.boot.utils.service;

import java.util.UUID;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月11日 下午5:11:16
 *
 */
public class UuidUtil {
	public static String getUuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
 