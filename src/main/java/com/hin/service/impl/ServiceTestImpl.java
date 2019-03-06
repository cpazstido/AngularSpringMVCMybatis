package com.hin.service.impl;

import com.hin.service.ServiceTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service("testService11111111")
public class ServiceTestImpl implements ServiceTest
        ,BeanPostProcessor
{
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization "+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization "+s);
        return o;
    }
}
