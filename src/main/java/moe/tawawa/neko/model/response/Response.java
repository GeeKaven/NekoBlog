package moe.tawawa.neko.model.response;

import lombok.Data;
import moe.tawawa.neko.model.consts.ErrorCode;

import java.io.Serializable;

/**
 * @author: GeeKaven
 * @date: 2019/3/19 20:28
 */
@Data
public class Response<T> implements Serializable {
    private Integer code = ErrorCode.SUCCESS;
    private T data;

    public Response() {

    }

    private Response(T data) {
        this.data = data;
    }
}
