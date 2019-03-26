package example.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/14
 */
@Aspect
@Component
public class AOPtest {

    @Pointcut("execution(* example.dao.*.*(..))")
    public void pointcut(){}


    @Before("execution(* example.dao.*.*(..))")
    public void befor(JoinPoint joinPoint) {

        System.out.println(joinPoint.getSignature().getName() + "前置通知执行了...");
    }

    @AfterReturning(value = "execution(* example.dao.*.*(..))", returning = "result")
    public void after(Object result) {
        System.out.println("后置通知..." + result);
    }

    //环绕通知
    //环绕通知需要携带ProceedingJoinPoint 类型的参数
    //环绕通知类似于动态代理的全过程 ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
    //且环绕通知必须有返回值，返回值即为目标方法的返回值。

    @Around("execution(* example.dao.*.*(..))")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) {

        //定义返回值
        Object result = null;
        try {
            //前置通知
            System.out.println("前置通知...");
            result = proceedingJoinPoint.proceed();//执行目标方法  不加这句则不执行目标方法
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("异常通知...");
        } finally {
            //后置通知
            System.out.println("后置通知...");
        }
        //返回通知
        System.out.println("返回通知...");

        return 1000;
    }
}
