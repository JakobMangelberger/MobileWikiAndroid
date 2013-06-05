package com.mobilewiki.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MobileWikiRestObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String function_name;
	private List<Object> param_list;
	
	public MobileWikiRestObject() {
		this.function_name = "";
		this.param_list = new ArrayList<Object>();
	}
	
	public MobileWikiRestObject(String function_name, List<Object> param_list) {
		setFunction_name(function_name);
		setParam_list(param_list);
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}

	public List<Object> getParam_list() {
		return param_list;
	}

	public void setParam_list(List<Object> param_list) {
		this.param_list = param_list;
	}
}
