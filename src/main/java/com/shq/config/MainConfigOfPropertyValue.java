package com.shq.config;

import com.shq.bean.ProfileDemo;
import com.shq.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 属性赋值配置类
 */
@Configuration
public class MainConfigOfPropertyValue {

    @Bean
    public Student student() {
        return new Student();
    }

    @Profile("dev")
    @Bean
    public ProfileDemo profileDemoDev() {
        ProfileDemo profileDemo = new ProfileDemo();
        profileDemo.setEnv("dev");
        return profileDemo;
    }

    @Profile("test")
    @Bean
    public ProfileDemo profileDemoTest() {
        ProfileDemo profileDemo = new ProfileDemo();
        profileDemo.setEnv("test");
        return profileDemo;
    }

    @Profile("prod")
    @Bean
    public ProfileDemo profileDemoProd() {
        ProfileDemo profileDemo = new ProfileDemo();
        profileDemo.setEnv("prod");
        return profileDemo;
    }

}
