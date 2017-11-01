package com.hin.service.impl;

import com.hin.service.AService;
import com.hin.service.BService;
import com.hin.service.BeanService;
import com.hin.service.CService;

public class AServiceImpl implements AService {
    AServiceImpl(){
        System.out.println("AServiceImpl constructor invoked!");
    }

    private BService bService;

    public BService getbService() {
        return bService;
    }

    public void setbService(BService bService) {
        this.bService = bService;
    }
}
