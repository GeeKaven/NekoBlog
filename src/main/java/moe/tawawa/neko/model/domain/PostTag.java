package moe.tawawa.neko.model.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: GeeKaven
 * @date: 2019/3/25 19:57
 */
@Data
@Table(name = "neko_post_tag")
@EntityListeners(AuditingEntityListener.class)
public class PostTag {

    /**
     * 文章，tag，关联编号
     */
    private Long id;

    /**
     * 文章编号
     */
    private Long postId;

    /**
     * tag编号
     */
    private Long tagId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 创建时间
     */
    @CreatedDate
    private Date createdAt;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private Date updatedAt;
}
