package moe.tawawa.neko.model.response;

import lombok.Data;
import moe.tawawa.neko.model.enums.ErrorCode;

/**
 * @author: GeeKaven
 * @date: 2019/3/19 20:28
 */
@Data
public class JsonResponse {
    private Integer code;
    private String msg;
    private Object data;

    public JsonResponse() {

    }

    public JsonResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
