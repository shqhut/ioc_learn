package com.shq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.shq.aop")
@EnableAspectJAutoProxy
public class MainConfigOfAop {


}
