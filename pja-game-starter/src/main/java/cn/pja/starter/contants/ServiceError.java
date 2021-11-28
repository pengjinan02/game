package cn.pja.starter.contants;

/**
 * 错误信息枚举类
 *  注：为了错误信息统一管理
 * @author 彭金安
 * @DATE 2021/7/25
 */
public enum ServiceError {
    //====== 通用错误 ======
    ILLEGAL_ARGUMENT_EXCEPTION("E1001", "参数错误"),
    MQ_PRODUCER_EXCEPTION("E1002", "MQ消息发送出错"),

    //====== 用户 ======
    USER_LOGIN_FAIL("E10001","登录失败，用户名或密码错误！"),
    ;

    private final String code;
    private final String message;

    ServiceError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
