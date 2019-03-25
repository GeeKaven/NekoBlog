package moe.tawawa.neko.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 23:41
 */
@Data
public class PostUpdateRequest {

    private Long id;

    private String title;

    private String content;

    private Long categoryId;

    private Boolean enableComment;

    private Integer type;
}
