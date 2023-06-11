package com.shq;

import com.shq.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void testImport() {
        printBeans(applicationContext);
    }

    @Test
    public void testLifeCycle() {
        applicationContext.close();
    }

    @Test
    public void testFactoryBean() {
        // 工厂bean获取的是调用getObject()方法创建的对象
        // 单实例bean只会调用一次getObject()去创建bean
        Object bean = applicationContext.getBean("personFactoryBean");
        System.out.println("personFactoryBean的类型"+bean.getClass());
        printBeans(applicationContext);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        //获取容器中所有定义的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
