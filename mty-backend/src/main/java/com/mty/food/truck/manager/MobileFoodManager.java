package com.mty.food.truck.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mty.food.truck.dto.request.MobileFoodQueryRequest;
import com.mty.food.truck.entity.MobileFood;
import com.mty.food.truck.enums.FacilityTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class MobileFoodManager {

    public QueryWrapper<MobileFood> buildQueryWrapper(MobileFoodQueryRequest request) {
        log.info("Building query parameters:", request.getFacilityType() + ", " + request.getStatus()+ ", " + request.getApplicant());
        QueryWrapper<MobileFood> queryWrapper = new QueryWrapper<>();
        Integer facilityType = request.getFacilityType();
        if (facilityType != null) {
            String desc = FacilityTypeEnum.getDesc(facilityType);
            if (desc != null) {
                queryWrapper.lambda().eq(MobileFood::getFacilityType, desc);
            }
        }
        if (StringUtils.hasText(request.getApplicant())) {
            queryWrapper.lambda().like(MobileFood::getApplicant, request.getApplicant());
        }

        if (StringUtils.hasText(request.getStatus())) {
            queryWrapper.lambda().like(MobileFood::getStatus, request.getStatus());
        }
        return queryWrapper;
    }
}
