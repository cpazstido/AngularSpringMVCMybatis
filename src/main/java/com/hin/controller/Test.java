package com.hin.controller;

import com.hin.entity.AccountDO;
import com.hin.service.impl.BeanLifeImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Test {
    public static void main(String[] args)throws Exception {
//        springTest();
        AccountDO accountDO = new AccountDO();
        accountDO.setUserId(111222);
        System.out.println(getProperty(accountDO,"userId"));
        System.out.println(invokeMethod(accountDO,"setUserId", new Object[]{123}));
        System.out.println("");
    }

    public static Object getProperty(Object owner,String fieldName) throws Exception{
        Class ownerClass = owner.getClass();
        Field field = ownerClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object property = field.get(owner);
        return property;
    }

    public static Object invokeMethod(Object owner,String methodName,Object[] args) throws Exception{
        Class ownerClass = owner.getClass();
        Class[] argsClass = new Class[args.length];
        for(int i=0;i<args.length;i++){
            argsClass[i] = args[i].getClass();
        }
        Method method = ownerClass.getMethod(methodName,argsClass);
        return method.invoke(owner,args);
    }

    public static void springTest(){
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        cxt.getBean("aService");
        System.out.println("");
    }
}
