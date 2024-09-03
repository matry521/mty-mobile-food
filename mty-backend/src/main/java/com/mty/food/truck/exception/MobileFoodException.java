package com.mty.food.truck.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MobileFoodException extends RuntimeException {

    @Schema(name = "状态码")
    private int code;
    @Schema(name = "返回消息")
    private String message;
}
