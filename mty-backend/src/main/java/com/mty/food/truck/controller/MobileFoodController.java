package com.mty.food.truck.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.mty.food.truck.common.R;
import com.mty.food.truck.converter.MobileFoodConverter;
import com.mty.food.truck.dto.request.MobileFoodQueryRequest;
import com.mty.food.truck.entity.MobileFood;
import com.mty.food.truck.enums.FacilityTypeEnum;
import com.mty.food.truck.manager.MobileFoodManager;
import com.mty.food.truck.service.IMobileFoodService;
import com.mty.food.truck.vo.MobileFoodVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Mobile food controller", description = "Mobile food controller")
@RestController
@RequestMapping("/api/mobile/food")
public class MobileFoodController {

    @Resource
    private IMobileFoodService mobileFoodService;
    @Resource
    private MobileFoodConverter mobileFoodConverter;
    @Resource
    private MobileFoodManager mobileFoodManager;

    @CrossOrigin("*")
    @ApiOperationSupport(order = 1)
    @Operation(summary = "根据条件过滤查询列表")
    @PostMapping("/list")
    public R<List<MobileFoodVO>> queryMobileFoodFacilities(@RequestBody MobileFoodQueryRequest request) {
        // 1.项目编排，获取信息
        QueryWrapper<MobileFood> queryWrapper = mobileFoodManager.buildQueryWrapper(request);
        // 2.业务查询处理
        List<MobileFood> list = mobileFoodService.list(queryWrapper);
        // 3.数据转换
        return R.data(mobileFoodConverter.entityListToVOList(list));
    }

}
