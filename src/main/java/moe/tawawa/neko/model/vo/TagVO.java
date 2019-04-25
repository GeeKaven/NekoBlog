package moe.tawawa.neko.model.vo;

import lombok.Data;
import moe.tawawa.neko.model.domain.Tag;
import org.springframework.beans.BeanUtils;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 23:25
 */
@Data
public class TagVO {
    private Long id;

    private String name;

    public TagVO() {

    }

    public TagVO(Tag tag) {
        BeanUtils.copyProperties(tag, this);

    }
}
