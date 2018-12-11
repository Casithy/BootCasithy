package com.casithy.boot.utils.result; 

/**
 * 
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年11月1日 上午11:31:03
 *
 */
public enum ResultCodeEnum {
	SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    public int code;

    ResultCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
 