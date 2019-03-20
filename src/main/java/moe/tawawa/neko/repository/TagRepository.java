package moe.tawawa.neko.repository;

import moe.tawawa.neko.model.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:06
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
