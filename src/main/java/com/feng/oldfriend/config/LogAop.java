package com.feng.oldfriend.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Auther: cookie
 * @Date: 2018/7/27 10:17
 * @Description: 使用AOP统一处理Web请求日志
 */
@Aspect
@Component
@Slf4j
public class LogAop {
    /**DeclareParaents
     * 指定切点
     * 匹配 com.sungiant.upm 包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(public * com.feng.oldfriend.controller.*.*(..))")
    public void webLog(){
    }

    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        log.info("方法："+signature.getName());
        //AOP代理类的名字
        log.info("方法所在包:"+signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] strings = methodSignature.getParameterNames();
        log.info("参数名："+Arrays.toString(strings));
        log.info("参数值ARGS : " + Arrays.toString(joinPoint.getArgs()));
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        // 记录下请求内容
        log.info("请求URL : " + req.getRequestURL().toString());
        log.info("HTTP_METHOD : " + req.getMethod());
        log.info("IP : " + req.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    /**
     * 处理完请求返回内容
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     * @param jp
     */
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        log.error("方法异常.....");
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("webLog()")
    public void after(JoinPoint jp){

    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     * @param pjp
     * @return
     */
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            Object o =  pjp.proceed();
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
