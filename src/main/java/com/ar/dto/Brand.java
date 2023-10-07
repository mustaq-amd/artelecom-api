package com.ar.dto;

public enum Brand {

	APPLE("Apple"),
    SAMSUNG("Samsung"),
    XIAOMI("Xiaomi"),
    HUAWEI("Huawei"),
    ONEPLUS("OnePlus"),
    GOOGLE_PIXEL("Google Pixel"),
    MOTOROLA("Motorola"),
    LG("LG"),
    VIVO("Vivo"),
    OPPO("Oppo");

    private final String brandName;

    Brand(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

}
