package moe.tawawa.neko.model.domain;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author: laiang
 * @date: 2019/3/17 23:15
 */
@Data
@Table(name = "options")
public class Options {

    private String key;

    private String value;
}
