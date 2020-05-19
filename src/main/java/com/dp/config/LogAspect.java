package com.dp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author jacob.deng
 * @Date 2020-05-19 15:16
 */
@Aspect
@Component
public class LogAspect {

    /**
     * slf4j日志
     */
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * Pointcut 切入点
     * 匹配com.dp.controller 包下面的所有方法
     */
    @Pointcut("execution(public * com.dp.controller.*.*(..))")
    public void webLog() {}

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    @Around(value = "webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            logger.info("执行前");
            Object o = pjp.proceed();
            logger.info("执行后");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info("异常后");
            return null;
        }
    }

    /**
     * 方法执行结束，不管是抛出异常或者正常退出都会执行
     * @param joinPoint
     */
    @After(value = "webLog()")
    public void after(JoinPoint joinPoint) {
        logger.info("4、After：方法最后执行.....");
    }

    /**
     * 方法执行结束，增强处理
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        logger.info("5、AfterReturning：方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     * @param joinPoint
     */
    @AfterThrowing(value = "webLog()")
    public void throwss(JoinPoint joinPoint) {
        logger.error("AfterThrowing：方法异常时执行.....");
    }


}
