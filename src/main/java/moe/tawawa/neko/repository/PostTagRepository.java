package moe.tawawa.neko.repository;

import moe.tawawa.neko.model.domain.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: GeeKaven
 * @date: 2019/3/25 23:15
 */
public interface PostTagRepository extends JpaRepository<PostTag, Long> {
    PostTag findPostTagByPostIdAndTagId(Long postId, Long tagId);
}
