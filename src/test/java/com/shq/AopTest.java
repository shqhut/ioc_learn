package com.shq;

import com.shq.aop.MathCalculate;
import com.shq.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

    @Test
    public void testAop(){
        MathCalculate calculate = applicationContext.getBean(MathCalculate.class);
        calculate.div(1,0);
    }
}
