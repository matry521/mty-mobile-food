package com.mty.food.truck.enums;


import java.util.Objects;

public enum FacilityTypeEnum {

    TRUCK(1, "Truck"),
    PUSH_CART(2, "Push Cart"),
    UNKNOWN(3, "");

    FacilityTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private Integer type;
    private String desc;

    public static String getDesc(Integer type) {
        FacilityTypeEnum[] values = FacilityTypeEnum.values();
        for (FacilityTypeEnum value : values) {
            if (Objects.equals(value.type, type)) {
                return value.desc;
            }
        }
        return null;
    }


}
