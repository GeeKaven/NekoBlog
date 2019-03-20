package moe.tawawa.neko.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:30
 */
@Data
public class CreatePostRequest {
    private String title;

    private String content;

    private Long categoryId;

    private Boolean enableComment;

    private Integer type;
}
