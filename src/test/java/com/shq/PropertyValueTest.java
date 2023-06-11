package com.shq;

import com.shq.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertyValueTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

    @Test
    public void testImport() {
        printBeans(applicationContext);
    }

    @Test
    public void testProfile() {
        // 创建容器时指定环境
        // 使用无参构造器创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 设置需要激活的环境
        context.getEnvironment().setActiveProfiles("dev","prod");
        // 配置主配置类
        context.register(MainConfigOfPropertyValue.class);
        // 启动刷新容器
        context.refresh();
        // 打印bean
        printBeans(context);
    }


    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        //获取容器中所有定义的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
