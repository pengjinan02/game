package cn.pja.starter.exception;

import cn.pja.starter.contants.ServiceError;
import lombok.Data;

/**
 * 内部服务异常，一般用于返回可预知的错误信息
 *
 * @author 彭金安
 * @DATE 2021/10/4
 */
@Data
public class ServiceException extends RuntimeException{
    /**
     * 错误码
     */
    private String code;

    public ServiceException(ServiceError serviceError) {
        super(serviceError.getMessage());
        this.code = serviceError.getCode();
    }

    public ServiceException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.code = errorCode;
    }
}
