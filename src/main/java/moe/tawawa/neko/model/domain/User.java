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
 * @date: 2019/3/17 23:24
 */
@Data
@Table(name = "neko_user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    public static final Integer STATUS_NORMAL = 0;
    public static final Integer STATUS_DEL = 1;

    /**
     * 用户编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 用户密码 md5
     */
    private String password;

    /**
     * 用户token
     */
    private String token;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户状态
     */
    private Integer status = STATUS_NORMAL;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
