package moe.tawawa.neko.exception;

import moe.tawawa.neko.model.enums.ErrorCode;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 20:21
 */
public class BaseException extends RuntimeException {
    private Integer code;

    private String errorMsg;

    public BaseException() {

    }

    public BaseException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.errorMsg = errorCode.getErrorMsg();
    }
}
