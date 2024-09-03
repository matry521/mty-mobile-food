package com.mty.food.truck.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MobileFoodSyncTask {

    /**
     * desc: 请求网址同步数据进行更新数据库信息
     * 方案替换：生产处应该引入xxl-job进行管理 TODO
     */
    @Scheduled(cron="0 0 2 * * *")   //每天凌晨2点执行一次
    public void execute(){

        // TODO Auto-generated method stub
        // 1.请求网站地址，获取数据

        // 2.通过json工具解析数据

        // 3.转换数据遍历存入list

        // 4.批量更新数据库，此处根据location_id唯一键处理： on duplicate key update

    }
}
