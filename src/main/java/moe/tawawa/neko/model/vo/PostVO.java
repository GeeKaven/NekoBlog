package moe.tawawa.neko.model.vo;

import lombok.Data;
import moe.tawawa.neko.model.domain.Post;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 13:16
 */
@Data
public class PostVO {

    private Long id;

    private String title;

    private String content;

    private CategoryVO category;

    private List<TagVO> tags;

    private UserVO user;

    private Boolean published;

    public PostVO() {

    }

    public PostVO(Post post) {
        BeanUtils.copyProperties(post, this);
        this.published = Post.STATUS_PUBLISH.equals(post.getStatus());
    }

}
