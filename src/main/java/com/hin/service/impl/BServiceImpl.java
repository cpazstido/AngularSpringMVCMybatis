package com.hin.service.impl;

import com.hin.service.AService;
import com.hin.service.BService;
import com.hin.service.CService;

public class BServiceImpl implements BService {
    private AService aService;

    public AService getaService() {
        return aService;
    }

    public void setaService(AService aService) {
        this.aService = aService;
    }

    BServiceImpl(){
        System.out.println("BServiceImpl constructor invoked!");
    }
}
