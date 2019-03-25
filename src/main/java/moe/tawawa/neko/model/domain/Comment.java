package moe.tawawa.neko.model.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: GeeKaven
 * @date: 2019/3/17 22:44
 */
@Data
@Entity
@Table(name = "neko_comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    public static final Integer AUTHOR_TYPE_VISITOR = 0;
    public static final Integer AUTHOR_TYPE_OWNER = 1;

    public static final Integer TYPE_POST_COMMENT = 0;
    public static final Integer TYPE_REPLY_COMMENT = 1;

    public static final Integer STATUS_AUDITING = 0;
    public static final Integer STATUS_PUBLISH = 1;
    public static final Integer STATUS_DEL = 2;

    /**
     * 评论编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 评论文章编号
     */
    private Long postId;

    /**
     * 评论作者
     */
    private String author;

    /**
     * 评论作者类型 （游客，作者）
     */
    private Integer authorType;

    /**
     * 评论者邮件
     */
    private String email;

    /**
     * 评论者ip
     */
    private String ip;

    /**
     * 评论者agent
     */
    private String agent;

    /**
     * 评论类容
     */
    private String content;

    /**
     * 评论类型 （主，回复）
     */
    private Integer type;

    /**
     * 父评论编号
     */
    private Long parentId;

    /**
     * 根评论编号
     */
    private Long rootId;

    /**
     * 评论状态 （待审，发布，删除）
     */
    private Integer status;

    /**
     * 创建时间
     */
    @CreatedDate
    private Date createdAt;

    /**
     * 修改时间
     */
    @LastModifiedDate
    private Date updatedAt;
}
