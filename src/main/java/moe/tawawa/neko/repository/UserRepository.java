package moe.tawawa.neko.repository;

import moe.tawawa.neko.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:07
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
