package com.hin.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class QuartzService {
    @Scheduled(cron = "0/1 * *  * * ? ")
    public void execute(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(simpleDateFormat.format(new Date()));
    }
}
