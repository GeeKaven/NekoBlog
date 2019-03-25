package moe.tawawa.neko.model.enums;

import lombok.Getter;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 20:24
 */
@Getter
public enum ErrorCode {

    SUCCESS(100000, "请求成功"),
    BAD_REQUEST(100001, "请求错误"),
    NOT_EXIST(100002, "请求的数据不存在"),
    POST_TAG_NOT_EXIST(100003, "文章与标签没有关联")
    ;

    private int code;
    private String errorMsg;

    ErrorCode(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }
}
