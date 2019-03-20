package moe.tawawa.neko.repository;

import moe.tawawa.neko.model.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:04
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
