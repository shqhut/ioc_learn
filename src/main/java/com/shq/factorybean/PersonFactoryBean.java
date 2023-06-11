package com.shq.factorybean;

import com.shq.bean.Person;
import org.springframework.beans.factory.FactoryBean;

public class PersonFactoryBean implements FactoryBean<Person> {

    // 返回一个Person bean会被添加到容器中
    @Override
    public Person getObject() throws Exception {
        System.out.println("调用ColorFactoryBean...getObject方法");
        return new Person("PersonFactoryBean测试",100);
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
