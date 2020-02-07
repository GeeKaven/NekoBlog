package moe.tawawa.neko.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: GeeKaven
 * @date: 2019/3/25 20:34
 */
@Data
@EqualsAndHashCode(callSuper =  false)
public class ElementPostRequest extends ListRequest {
    private Long id;
}
