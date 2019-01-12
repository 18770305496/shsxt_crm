package com.shsxt.crm.task;

import com.shsxt.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xlf on 2018/10/23.
 */
//@Component
public class TaskJob {

    @Autowired
    private CustomerService customerService;

    @Scheduled(cron = "0/5 * * * * ? ")
    public void job01(){
        System.out.println("============开始定时任务============");
        customerService.addLossCustomers();
        System.out.println("============结束定时任务============");
    }
}
