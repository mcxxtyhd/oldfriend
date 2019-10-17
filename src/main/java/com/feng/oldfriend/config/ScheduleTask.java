package com.feng.oldfriend.config;

import com.feng.oldfriend.service.LyjRequirementApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/28 16:18
 * @description：
 */
@Component
@Slf4j
public class ScheduleTask {

    @Autowired
    private LyjRequirementApplyService lyjRequirementApplyService;

//    @Scheduled(cron = "0/15 * * * * ? ")
    @Scheduled(cron = "0 0 0 1/1 * ?")
    public void dealApplyTask() {
        log.info("定时任务启动");

        lyjRequirementApplyService.updateApplyFinish();
        System.out.println("This is a say method!"+new Date());
    }
}
