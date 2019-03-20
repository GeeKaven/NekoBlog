package moe.tawawa.neko.repository;

import moe.tawawa.neko.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:08
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
