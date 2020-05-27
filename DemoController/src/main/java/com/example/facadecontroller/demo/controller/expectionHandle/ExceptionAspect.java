package com.example.facadecontroller.demo.controller.expectionHandle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author Crh
 * @ProjectName Crh
 * @Description: 全局异常统一处理，切面
 * @date 2020/4/16 17:41
 */
@Aspect
@Component
public class ExceptionAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 方法调用前，先打印入参
     *
     * @param joinPoint 在类名模式串中，“.*”表示包下的所有类，而“..*”表示包、子孙包下的所有类。
     */
    @Before("execution(* com.example.facadecontroller.demo.controller..*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("开始打印日志...");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object arg : args) {
            stringBuilder.append(arg);
            logger.info(className + "的" + methodName + "入参是" + stringBuilder.toString());
        }
    }

    /**
     * 过程中检测
     *
     * @param joinPoint
     * @return
     */
//    @Around("execution(* com.example.facadecontroller.demo.controller..*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            //获取方法参数值数组
            Object[] args = joinPoint.getArgs();
            //得到其方法签名
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            //获取方法参数类型数组
            Class[] paramTypeArray = methodSignature.getParameterTypes();
            if (EntityManager.class.isAssignableFrom(paramTypeArray[paramTypeArray.length - 1])) {
                //如果方法的参数列表最后一个参数是entityManager类型，则给其赋值
//                args[args.length - 1] = entityManager;
            }
            logger.info("请求参数为{}", args);
            //动态修改其参数
            //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
            Object result = joinPoint.proceed(args);
            logger.info("响应结果为{}", result);
        } catch (Throwable e) {
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            logger.info(className + "的" + methodName + "方法" + "发生了异常");
        }
        return null;
    }

    /**
     * 返回后，打印出参
     * @param joinPoint
     * 返回值怎么确定呢？
     */
//    @AfterReturning(value = "execution(* com.example.facadecontroller.demo.controller..*(..))")
    public void afterReturn(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(className + "的" + methodName + "结果为：");
    }

    public static void main(String[] args) {
        int now = LocalDate.now().lengthOfYear(); // 366
        int month = LocalDate.now().lengthOfMonth();// 30  当月多少天
        System.out.println(month);
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("今天是"+day);
        Time time = Time.valueOf("23:59:59"); //必须是 “hh:mm:ss” 类型 pattern
        System.out.println(time);
    }
}
