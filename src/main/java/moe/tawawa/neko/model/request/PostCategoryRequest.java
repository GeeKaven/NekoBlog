package moe.tawawa.neko.model.request;

import lombok.Data;

/**
 * @author: GeeKaven
 * @date: 2019/3/25 20:30
 */
@Data
public class PostCategoryRequest {
    private Long categoryId;

    private Long postId;
}
