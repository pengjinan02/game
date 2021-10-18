package cn.pja.utils;

import cn.pja.Interceptor.ExceptionInterceptor;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 *
 * @author 彭金安
 * @DATE 2021/9/13
 */
public class LogUtils {

    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void warn(String className, String methodName, String code, String message, String arg) {
        logger.warn("类名：[" + className + "]\t" +
                "方法名：[" + methodName + "]\t" +
                "错误码：[" + code + "]\t" +
                "错误信息：[" + message + "]\t" +
                "参数：" + arg);
    }

}
