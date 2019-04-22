package moe.tawawa.neko.model.request;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 21:20
 */
public class ListRequest {

    private Integer page = 1;

    private Integer size = 10;

    public ListRequest() {

    }

    public ListRequest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
