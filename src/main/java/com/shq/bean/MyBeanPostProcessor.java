package com.shq.bean;

import com.shq.bean.ioclifecycle.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Car) {
            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization ------ " + beanName + " ------" + " bean的类型 ----" + bean.getClass());
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Car) {
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization ------ " + beanName + " ------" + " bean的类型 ----" + bean.getClass());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
