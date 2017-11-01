package com.hin.service.impl;

import com.hin.service.AService;
import com.hin.service.CService;

public class CServiceImpl implements CService {
    CServiceImpl(){
        System.out.println("CServiceImpl constructor invoked!");
    }

    private AService aService;

    public AService getaService() {
        return aService;
    }

    public void setaService(AService aService) {
        this.aService = aService;
    }
}

