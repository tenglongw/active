package com.mumway.active.utile;

import com.alibaba.fastjson.JSONObject;

public class Result {
	private Integer status = 0;
	private String msg = "";
	
	private Object data;
	
	public static String MSG_OK = "成功";
	public static String MSG_FAIL = "失败";
	
	public static int STATUS_OK = 1;
	public static int STATUS_FAIL = 0;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String toJsonString(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", getMsg());
		jsonObject.put("status", getStatus());
		jsonObject.put("data", getData());
		return jsonObject.toJSONString();
	}
	
	/**
	 * 简便的方法获取成功状态的ROOT
	 * @param msg 成功后的信息
	 */
	public static Result getRootOK(String msg){
		Result root = new Result();
		root.setStatus(STATUS_OK);
		root.setMsg(msg);
		return root;
	}
	
	/**
	 * 默认成功状态的ROOT
	 */
	public static Result getRootOKAndSimpleMsg(){
		Result root = new Result();
		root.setStatus(STATUS_OK);
		root.setMsg(MSG_OK);
		return root;
	}
	
	/**
	 * 简便的方法获取失败状态的ROOT
	 * @param msg 失败后的信息
	 */
	public static Result getRootFail(String msg){
		Result root = new Result();
		root.setStatus(STATUS_FAIL);
		root.setMsg(msg);
		return root;
	}
	
	/**
	 * 默认失败状态的ROOT
	 */
	public static Result getRootFailAndSimpleMsg(){
		Result root = new Result();
		root.setStatus(STATUS_FAIL);
		root.setMsg(MSG_FAIL);
		return root;
	}
}
