package com.shq.config;

import com.shq.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata annotation metadata of the importing class
     *                               当前类的注解信息，
     * @param registry current bean definition registry
     *                 beanDefinition注册类，通过BeanDefinitionRegistry.registerBeanDefinition
     *                 将需要添加到容器中的bean手动注册到容器中
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.shq.bean.Blue");
        if (definition) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Rainbow.class);
            registry.registerBeanDefinition("rainbow",beanDefinition);
        }
    }
}
