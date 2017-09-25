package com.hin.service.impl;

import com.hin.service.BeanLife;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring bean 生命周期
 * 1、constructor
 * 2、setter
 * 3、BeanNameAware
 * 4、BeanFactoryAware
 * 5、ApplicationContextAware
 * 6、BeanPostProcessor  postProcessBeforeInitialization（）
 * 7、InitializingBean   afterPropertiesSet（）
 * 8、init-method（）
 * 9、BeanPostProcessor   POSTProcessAfterInitialization（）
 * 10、DisposableBean    destroy（）
 * 11、destory-method()
 */

public class BeanLifeImpl implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
//        BeanPostProcessor,
        DisposableBean,
        InitializingBean,
        BeanLife{
    private String name;
    private int age;

    BeanLifeImpl(){
        System.out.println("constructor invoked!");
    }

    public void setName(String name) {
        System.out.println("setter invoked! "+name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("setter invoked! "+age);
        this.age = age;
    }

    public void setBeanName(String s) {
        System.out.println("BeanNameAware setBeanName(String beanId) "+s);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware setBeanFactory(BeanFactory beanFactory) "+beanFactory);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware setApplicationContext(ApplicationContext) "+applicationContext);
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
//        System.out.println("BeanPostProcessor postProcessBeforeInitialization(Object o, String s) "+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
//        System.out.println("BeanPostProcessor postProcessAfterInitialization(Object o, String s) " +s);
        return o;
    }

    public void init(){
        System.out.println("init invoked!");
    }

    public void destroy() throws Exception {
        System.out.println("destroy()");
    }

    public void destroyMethod(){
        System.out.println("destroyMethod invoked!");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet()");
    }
}
