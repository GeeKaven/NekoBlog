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
 * @date: 2019/3/17 23:02
 */
@Data
@Entity
@Table(name = "neko_tag")
@EntityListeners(AuditingEntityListener.class)
public class Tag {

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
     * 标签名称
     */
    private String name;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
