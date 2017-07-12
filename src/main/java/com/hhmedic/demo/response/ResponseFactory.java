package com.hhmedic.demo.response;

/**
 * Created by lcssos on 2017/6/14.
 */
public class ResponseFactory {

	private static <T> Response<T> getResponse(int status,String message,T data){
		return (Response<T>) Response.builder().status(status).message(message).data(data).build();
	}

	public static <T> Response<T> getResponse(ResponseEnum responseEnum,T data){
		return getResponse(responseEnum.getCode(),responseEnum.getMessage(),data);
	}
	public static Response getResponse(ResponseEnum responseEnum){
		return getResponse(responseEnum.getCode(),responseEnum.getMessage(),null);
	}

	/**
	 * 返回成功内容
	 * @param message
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> Response<T> getSuccess(String message,T data){
		return getResponse(ResponseEnum.success.getCode(),message,data);
	}
	public static <T> Response<T> getSuccessData(T data){
		return getResponse(ResponseEnum.success.getCode(),ResponseEnum.success.getMessage(),data);
	}
	public static Response getSuccessMessage(String message){
		return getResponse(ResponseEnum.success.getCode(),message,null);
	}
	public static Response getSuccess(){
		return getResponse(ResponseEnum.success.getCode(),ResponseEnum.success.getMessage(),null);
	}


	/**
	 * 返回失败内容
	 * @param message
	 * @return
	 */
	public static Response getFailure(String message){
		return getResponse(ResponseEnum.failure.getCode(),message,null);
	}
	public static Response getFailure(){
		return getResponse(ResponseEnum.failure.getCode(),ResponseEnum.failure.getMessage(),null);
	}



}
