package com.shq.aop;

import org.springframework.stereotype.Component;

/**
 * aop测试业务方法
 */
@Component
public class MathCalculate {

    public int div(int a,int b) {
        return a/b;
    }

}
