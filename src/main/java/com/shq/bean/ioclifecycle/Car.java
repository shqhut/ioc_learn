package com.shq.bean.ioclifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements InitializingBean, DisposableBean, ApplicationContextAware {

    public Car() {
        System.out.println("执行Car的构造方法....");
    }

    public void init_method() {
        System.out.println("car.....init().....");
    }

    public void destroy_method() {
        System.out.println("car.....destroy_method().....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car.....afterPropertiesSet().....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("car.....destroy().....");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("car.....postConstruct()....");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("car.....preDestroy()....");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("car执行setApplicationContext........");
    }
}
