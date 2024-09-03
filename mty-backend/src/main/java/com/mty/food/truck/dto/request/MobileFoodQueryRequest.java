package com.mty.food.truck.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "查询list req")
public class MobileFoodQueryRequest {

    @Schema(description = "设施类型： 1-trunk 2-push cart 3-未知")
    private Integer facilityType;

    @Schema(description = "状态")
    private String status;

    @Schema(description = "申请人，模糊查询")
    private String applicant;


}
