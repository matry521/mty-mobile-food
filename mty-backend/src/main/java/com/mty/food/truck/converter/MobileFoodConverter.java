package com.mty.food.truck.converter;

import com.mty.food.truck.entity.MobileFood;
import com.mty.food.truck.vo.MobileFoodVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MobileFoodConverter {

    MobileFoodVO entityToVO(MobileFood mobileFood);

    List<MobileFoodVO> entityListToVOList(List<MobileFood> list);
}
