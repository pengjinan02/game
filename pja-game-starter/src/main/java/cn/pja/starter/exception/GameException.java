package cn.pja.starter.exception;

import cn.pja.starter.contants.GameError;
import lombok.Data;

/**
 * 内部服务异常，一般用于返回可预知的错误信息
 *
 * @author 彭金安
 * @DATE 2021/10/4
 */
@Data
public class GameException extends RuntimeException{
    /**
     * 错误码
     */
    private String code;

    public GameException(GameError gameError) {
        super(gameError.getMessage());
        this.code = gameError.getCode();
    }

    public GameException(GameError gameError, Exception e) {
        super(gameError.getMessage(), e);
        this.code = gameError.getCode();
    }

    public GameException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.code = errorCode;
    }
}
