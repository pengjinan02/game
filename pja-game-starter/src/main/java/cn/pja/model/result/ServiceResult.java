package cn.pja.model.result;

import cn.pja.contants.ServiceError;
import lombok.Data;

/**
 * 查询结果服务封装类
 *
 * @author 彭金安
 * @DATE 2021/9/12
 */
@Data
public class ServiceResult<T> {
    /**
     * 结果集
     */
    private T result;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 构建查询失败结果
     * @param serviceError 错误码封装对象
     * @return 查询失败的结果
     */
    public static ServiceResult buildDefaultFailResult(ServiceError serviceError){
        ServiceResult<Object> serviceResult = new ServiceResult<>();
        serviceResult.setResult(null);
        serviceResult.setErrorCode(serviceError.getCode());
        serviceResult.setErrorMessage(serviceError.getMessage());
        serviceResult.setSuccess(false);
        return serviceResult;
    }

    /**
     * 构建查询失败结果
     * @param errorCode 错误码
     * @param errorMessage 错误信息
     * @return 查询失败的结果
     */
    public static ServiceResult buildDefaultFailResult(String errorCode, String errorMessage){
        ServiceResult<Object> serviceResult = new ServiceResult<>();
        serviceResult.setResult(null);
        serviceResult.setErrorCode(errorCode);
        serviceResult.setErrorMessage(errorMessage);
        serviceResult.setSuccess(false);
        return serviceResult;
    }

    /**
     * 构建查询成功结果
     * @param result 查询的结果集
     * @return 查询成功的结果
     */
    public static ServiceResult buildDefaultSuccessResult(Object result){
        ServiceResult<Object> serviceResult = new ServiceResult<>();
        serviceResult.setResult(result);
        serviceResult.setErrorCode(null);
        serviceResult.setErrorMessage(null);
        serviceResult.setSuccess(true);
        return serviceResult;
    }
}
