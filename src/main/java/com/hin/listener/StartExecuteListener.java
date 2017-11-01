package com.hin.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class StartExecuteListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("==================");
        System.out.println("ApplicationListener");
        System.out.println("==================");
    }
}
