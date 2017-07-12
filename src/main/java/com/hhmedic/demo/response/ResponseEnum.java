package com.hhmedic.demo.response;

/**
 * Created by lcssos on 2017/6/15.
 */
public enum ResponseEnum {
	success(200, "操作成功！"),
	failure(500, "操作失败！"),
    please_login(401,"请重新登录！")
			;

	private int code;     // 状态
	private String message; // 返回消息

	ResponseEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
