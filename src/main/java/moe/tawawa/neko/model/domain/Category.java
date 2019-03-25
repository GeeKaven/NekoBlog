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
 * @date: 2019/3/17 22:58
 */
@Data
@Entity
@Table(name = "neko_category")
@EntityListeners(AuditingEntityListener.class)
public class Category {

    public static final Integer STATUS_NORMAL = 0;
    public static final Integer STATUS_DEL = 1;

    /**
     * 分类编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 分类名称
     */
    private String name;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
