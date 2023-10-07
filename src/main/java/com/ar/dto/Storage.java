package com.ar.dto;

public enum Storage {
	
	GB32(32), GB64(64), GB128(128), GB256(256);

	private final int sizeInGB;

	Storage(int sizeInGB) {
	        this.sizeInGB = sizeInGB;
	    }

	public int getSizeInGB() {
		return sizeInGB;
	}
}
