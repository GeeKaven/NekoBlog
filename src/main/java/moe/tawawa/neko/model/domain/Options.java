package moe.tawawa.neko.model.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: GeeKaven
 * @date: 2019/3/17 23:15
 */
@Data
@Entity
@Table(name = "options")
public class Options {

    @Id
    private String key;

    private String value;
}
