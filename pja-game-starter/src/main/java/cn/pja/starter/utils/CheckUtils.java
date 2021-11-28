package cn.pja.starter.utils;

import cn.pja.starter.contants.ServiceError;

/**
 * 参数校验
 *
 * @author 彭金安
 * @DATE 2021/11/28
 */
public class CheckUtils {

    public static void isTrue(boolean flag) {
        if (flag) {
            throw new IllegalArgumentException(ServiceError.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
        }
    }

    public static void isTrue(boolean flag, String message) {
        if (flag) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean flag, ServiceError serviceError) {
        if (flag) {
            throw new IllegalArgumentException(serviceError.getMessage());
        }
    }
}
