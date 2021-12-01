package cn.pja.starter.utils;

import cn.pja.starter.contants.GameError;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
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

    public static void error(Logger logger, GameError gameError) {
        logger.error("错误码：" + gameError.getCode() + " 错误信息:" + gameError.getMessage());
    }

    public static void error(Logger logger, GameError gameError, String args) {
        logger.error("错误码：" + gameError.getCode() +
                " 错误信息：" + gameError.getMessage() +
                " 参数：" + args);
    }

    public static void info(Logger logger, String message) {
        logger.info(message);
    }
}
