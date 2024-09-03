package com.mty.food.truck.enums;


public enum StatusTypeEnum {

    APPROVED(1, "APPROVED"),
    EXPIRED(2, "EXPIRED"),
    ISSUED(3, "ISSUED"),
    REQUESTED(4, "REQUESTED"),
    SUSPEND(5, "SUSPEND");

    StatusTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private Integer type;
    private String desc;

}
