package cn.pja.starter.model.result;

import cn.pja.starter.contants.ServiceError;
import lombok.Data;

import java.util.List;

/**
 * 分页结果服务封装类1
 *
 * @author 彭金安
 * @DATE 2021/9/12
 */
@Data
public class PageResult<T> {
    /**
     * 查询结果
     */
    private List<T> result;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 调用是否成功
     */
    private Boolean success;
    /**
     * 下一个游标
     */
    private String nextCursor;
    /**
     * 上一个游标
     */
    private String preCursor;
    /**
     * 总数
     */
    private Integer totalCount;
    /**
     * 是否还有下一个
     */
    private Boolean hasNext;

    /**
     * 构建查询失败结果
     * @param serviceError 错误码封装对象
     * @return 查询失败的结果
     */
    public static PageResult buildDefaultFailResult(ServiceError serviceError){
        PageResult<Object> pageResult = new PageResult<>();
        pageResult.setResult(null);
        pageResult.setErrorCode(serviceError.getCode());
        pageResult.setErrorMessage(serviceError.getMessage());
        pageResult.setSuccess(false);
        return pageResult;
    }

    /**
     * 构建查询成功结果
     * @param resultList 查询的结果集
     * @return 查询成功的结果
     */
    public static PageResult buildDefaultSuccessResult(List<Object> resultList){
        PageResult<Object> pageResult = new PageResult<>();
        pageResult.setResult(resultList);
        pageResult.setErrorCode(null);
        pageResult.setErrorMessage(null);
        pageResult.setSuccess(true);
        return pageResult;
    }

    /**
     * 构建查询成功结果
     * @param resultList 查询结果集
     * @param nextCursor 下一个游标
     * @param preCursor 上一个游标
     * @param totalCount 总数
     * @param hasNext 是否还有下一个
     * @return 查询成功的结果
     */
    public static PageResult buildDefaultSuccessResult(List<Object> resultList, String nextCursor,
                                                       String preCursor, int totalCount, boolean hasNext){
        PageResult<Object> pageResult = new PageResult<>();
        pageResult.setResult(resultList);
        pageResult.setErrorCode(null);
        pageResult.setErrorMessage(null);
        pageResult.setSuccess(true);
        pageResult.setNextCursor(nextCursor);
        pageResult.setPreCursor(preCursor);
        pageResult.setTotalCount(totalCount);
        pageResult.setHasNext(hasNext);
        return pageResult;
    }
}
