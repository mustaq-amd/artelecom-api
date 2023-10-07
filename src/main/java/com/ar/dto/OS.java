package com.ar.dto;

public enum OS {
	
	ANDROID("Android"),
	IOS("Ios");
	
	private final String os;
	
	OS(String os){
		this.os = os;
	}
	
	public String getOs() {
		return os;
	}

}
