package moe.tawawa.neko.model.request;

import lombok.Data;

/**
 * @author: GeeKaven
 * @date: 2019/3/25 20:29
 */
@Data
public class PostTagRequest {
    private Long postId;

    private Long tagId;
}
