package com.ar.dto;

public enum DisplayType {
	
	LCD("Liquid Crystal Display"),
    LED("Light Emitting Diode"),
    OLED("Organic Light Emitting Diode"),
    AMOLED("Active Matrix Organic Light Emitting Diode"),
    IPS("In-Plane Switching"),
    RETINA("Retina Display"),
    TFT("Thin-Film Transistor");

    private final String description;

    DisplayType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
