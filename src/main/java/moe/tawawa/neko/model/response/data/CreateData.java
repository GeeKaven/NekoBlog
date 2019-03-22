package moe.tawawa.neko.model.response.data;

import lombok.Data;

/**
 * @author: GeeKaven
 * @date: 2019/3/21 0:01
 */
@Data
public class CreateData {
    private Long id;

    public CreateData() {

    }

    public CreateData(Long id) {
        this.id = id;
    }
}
