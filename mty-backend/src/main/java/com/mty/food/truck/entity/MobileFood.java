package com.mty.food.truck.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.io.Serializable;

@Data
@TableName("mobile_food")
@Schema(description = "Mobile food")
public class MobileFood implements Serializable {

    @Schema(description = "主键ID")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @Schema(description = "地区代码")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long locationId;
    @Schema(description = "申请人")
    private String applicant;
    @Schema(description = "truck; food cart; ''")
    private String facilityType;
    private String cnn;
    @Schema(description = "地区描述")
    private String locationDescription;
    @Schema(description = "地址")
    private String address;
    private String blockLot;
    private String block;
    private String lot;
    @Schema(description = "许可")
    private String permit;
    @Schema(description = "状态： APPROVED EXPIRED ISSUED REQUESTED SUSPEND")
    private String status;
    private String foodItems;
    private String X;
    private String Y;
    @Schema(description = "纬度")
    private String latitude;
    @Schema(description = "经度")
    private String longitude;
    private String schedule;
    private String daysHours;
    private String noiSent;
    private String approved;
    private String received;
    private String priorPermit;
    private String expirationDate;
    private String location;
    private String firePreventionDistricts;
    private String policeDistricts;
    private String supervisorDistricts;
    private String zipCodes;
    private String neighborhoods;
}
