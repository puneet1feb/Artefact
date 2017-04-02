package com.artefact.dto;

public class Status {
	
	private int code;
	private String desc;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Status(int code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	
	
	
	

}
