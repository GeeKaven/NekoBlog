package moe.tawawa.neko.model.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: GeeKaven
 * @date: 2019/3/14 1:56
 */

@Data
@Entity
@Table(name = "neko_post")
@EntityListeners(AuditingEntityListener.class)
public class Post {

    public static final Integer STATUS_DEFAULT = 0;
    public static final Integer STATUS_PUBLISH = 1;
    public static final Integer STATUS_DEL = 2;

    public static final Integer TYPE_POST = 0;
    public static final Integer TYPE_PAGE = 1;
    /**
     * 文章编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 文章用户
     */
    private Long userId;

    /**
     * 类目编号
     */
    private Long categoryId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    @Lob
    private String content;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 永久链接
     */
    private String permalink;

    /**
     * 文章状态 （草稿，发布，删除）
     */
    private Integer status = STATUS_DEFAULT;

    /**
     * 文章类型 （文章，页面）
     */
    private Integer type = TYPE_POST;

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