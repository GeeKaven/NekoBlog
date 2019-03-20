package moe.tawawa.neko.exception;

import moe.tawawa.neko.model.enums.ErrorCode;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 20:17
 */
public class BadRequestException extends  BaseException {

    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST);
    }

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }

}
