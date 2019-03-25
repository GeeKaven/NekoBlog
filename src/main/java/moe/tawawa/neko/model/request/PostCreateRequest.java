package moe.tawawa.neko.model.request;

import lombok.Data;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:30
 */
@Data
public class PostCreateRequest {
    private String title;

    private String content;

    private Long categoryId;

    private Boolean enableComment;

    private Integer type;
}