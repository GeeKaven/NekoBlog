package moe.tawawa.neko.model.vo;

import lombok.Data;
import moe.tawawa.neko.model.domain.Category;
import org.springframework.beans.BeanUtils;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 23:25
 */
@Data
public class CategoryVO {

    private Long id;

    private String name;

    public CategoryVO() {

    }

    public CategoryVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }
}
