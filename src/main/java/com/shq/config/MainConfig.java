package com.shq.config;

import com.shq.bean.MyBeanPostProcessor;
import com.shq.bean.Red;
import com.shq.bean.ioclifecycle.Car;
import com.shq.factorybean.PersonFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableAspectJAutoProxy
@Configuration
@Import({Red.class, MyImportSeletor.class, MyImportBeanDefinitionRegistrar.class, MyBeanPostProcessor.class})
public class MainConfig {

    @Bean
    public PersonFactoryBean personFactoryBean() {
        return new PersonFactoryBean();
    }

    @Bean(initMethod = "init_method",destroyMethod = "destroy_method")
    public Car car() {
        return new Car();
    }



}
