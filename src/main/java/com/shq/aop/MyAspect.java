package com.shq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 1、切面需要注入容器；
 * 2、通过@Aspect标记为切面；
 */
@Aspect
@Component
public class MyAspect {

    /**
     * execution(* 包名.*.*(..))
     * 1、execution(): 表达式主体。
     * 2、第一个*号：方法返回类型， *号表示所有的类型。
     * 3、包名：表示需要拦截的包名。
     * 4、第二个*号：表示类名，*号表示所有的类。
     * 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面( )里面表示方法的参数，两个句点表示任何参数
     *
     * 根据注解配置切点
     * @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.RequestMapping)")
     */
    @Pointcut("execution(* com.shq.aop.MathCalculate.div(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("[@Before]执行：" + joinPoint.getSignature().getName() + "开始执行" );
        System.out.println("入参信息：");
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("[@After]执行：" +joinPoint.getSignature().getName() + "方法执行结束");
    }

    /**
     * joinPoint一定要出现在参数表的第一位
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void methodReturn(JoinPoint joinPoint,Object result) {
        System.out.println("[@AfterReturning]执行：" + joinPoint.getSignature().getName() + "正常返回，运行结果" + result);
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "exception")
    public void afterThrow(JoinPoint joinPoint,Exception exception) {
        System.out.println("[@AfterThrowing]执行：" + joinPoint.getSignature().getName() + "异常信息：" + exception);
    }

}
