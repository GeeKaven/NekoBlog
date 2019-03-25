package moe.tawawa.neko.repository;

import moe.tawawa.neko.model.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:04
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * 根据文章类型和状态分页查询
     * @param status 状态
     * @param type 类型
     * @param pageable 分页信息
     * @return page
     */
    Page<Post> findByStatusAndType(Integer status, Integer type, Pageable pageable);

    /**
     * 根据文章类型，状态，类目分页查询
     * @param status 状态
     * @param type 类型
     * @param categoryId 类目id
     * @param pageable 分页信息
     * @return
     */
    Page<Post> findByStatusAndTypeAndCategoryId(Integer status, Integer type, Long categoryId, Pageable pageable);
}
