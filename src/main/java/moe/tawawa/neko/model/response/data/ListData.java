package moe.tawawa.neko.model.response.data;

import lombok.Data;

import java.util.List;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 20:45
 */
@Data
public class ListData<T> {
    private List<T> list;

    private long size;
}
