package com.ar.dto;

public enum Ram {
	
	 	GB4(4),
	    GB8(8),
	    GB12(12),
	    GB16(16),
	    GB32(32),
	    GB64(64);

	    private final int sizeInGB;

	    Ram(int sizeInGB) {
	        this.sizeInGB = sizeInGB;
	    }

	    public int getSizeInGB() {
	        return sizeInGB;
	    }

}
