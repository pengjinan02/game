package cn.pja.Interceptor;

import cn.pja.exception.ServiceException;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 异常拦截类
 *
 * @author 彭金安
 * @DATE 2021/10/4
 */
@Aspect
@Component
public class ExceptionInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionInterceptor.class);

    @Pointcut("execution(public * cn.pja.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        LOGGER.info("url={}",request.getRequestURL());
        // method
        LOGGER.info("method={}",request.getMethod());
        // ip
        LOGGER.info("id={}",request.getRemoteAddr());
        // class_method
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        // args[]
        LOGGER.info("args={}",joinPoint.getArgs());
        LOGGER.info("target={}", joinPoint.getTarget());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        StringBuffer url = request.getRequestURL();
        // ip
        String ip = request.getRemoteAddr();
        // 调用方法
        String classMethod = proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName();
        // 参数
        Object[] args = proceedingJoinPoint.getArgs();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage() + "]\n" +
                    "错误码\t：" + e.getCode() + "\n" +
                    "错误信息\t：" + e.getMessage() + "\n" +
                    "调用方法\t：" + classMethod + "\n" +
                    "参数\t\t：" + JSON.toJSONString(args));
        } catch (Exception e) {
            LOGGER.error("参数\t\t：" + JSON.toJSONString(args), e);
        }
        return result;
    }

}
