package com.mty.food.truck.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mty.food.truck.entity.MobileFood;
import com.mty.food.truck.mapper.MobileFoodMapper;
import com.mty.food.truck.service.IMobileFoodService;
import org.springframework.stereotype.Service;

@Service
public class MobileFoodServiceImpl extends ServiceImpl<MobileFoodMapper, MobileFood> implements IMobileFoodService {
}
