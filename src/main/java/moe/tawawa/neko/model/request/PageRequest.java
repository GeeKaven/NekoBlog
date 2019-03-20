package moe.tawawa.neko.model.request;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 21:20
 */
public class PageRequest {

    public static final Integer DEFAULT_SIZE = 10;

    private Integer page = 1;

    private String sort;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
