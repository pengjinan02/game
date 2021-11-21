package cn.pja.utils;

import cn.pja.contants.ServiceError;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志工具类
 *
 * @author 彭金安
 * @DATE 2021/9/13
 */
@Slf4j
@Component
public class LogUtils {
    public static void debug(Logger logger, String message) {
        logger.debug(message);
    }

    public static void warn(Logger logger, String message) {
        logger.warn(message);
    }

    public static void error(Logger logger, ServiceError serviceError) {
        logger.error("错误码：" + serviceError.getCode() + " 错误信息:" + serviceError.getMessage());
    }

    public static void error(Logger logger, ServiceError serviceError, String args) {
        logger.error("错误码：" + serviceError.getCode() +
                " 错误信息：" + serviceError.getMessage() +
                " 参数：" + args);
    }

    public static void info(Logger logger, String message) {
        logger.info(message);
    }
}
