package moe.tawawa.neko.model.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: laiang
 * @date: 2019/3/17 23:02
 */
@Data
@Table(name = "neko_tag")
@EntityListeners(AuditingEntityListener.class)
public class Tag {

    public static final Integer STATUS_NORMAL = 0;
    public static final Integer STATUS_DEL = 1;

    /**
     * 标签编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建用户编号
     */
    private Long userId;

    /**
     * 唯一字符串编号
     */
    private String nanoId;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签状态
     */
    private Integer status = STATUS_NORMAL;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
