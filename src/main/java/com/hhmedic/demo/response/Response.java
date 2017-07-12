package com.hhmedic.demo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lcssos on 2017/6/14.
 */
@Getter
@Setter
@Builder
public class Response<T> {
	private int status;
	private String message;
	private T data;
}
