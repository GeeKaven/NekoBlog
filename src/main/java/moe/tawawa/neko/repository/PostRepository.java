package moe.tawawa.neko.repository;

import moe.tawawa.neko.model.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:04
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * 根据文章类型和状态分页查询
     * @param status 状态 0, 1, 2
     * @param type 类型 0, 1
     * @param pageable 分页信息
     * @return page
     */
    Page<Post> findByStatusAndType(Integer status, Integer type, Pageable pageable);

}
