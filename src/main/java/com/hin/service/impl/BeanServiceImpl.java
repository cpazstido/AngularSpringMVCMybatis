package com.hin.service.impl;

import com.hin.service.BeanService;
import org.springframework.beans.factory.BeanNameAware;

public class BeanServiceImpl implements BeanService,BeanNameAware {
    private String aa;
    public void setBeanName(String name) {
        System.out.println("");
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public BeanServiceImpl(){
        System.out.println("BeanServiceImpl constructor invoked!");
    }
}
