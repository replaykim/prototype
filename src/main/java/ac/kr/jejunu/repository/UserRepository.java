package ac.kr.jejunu.repository;

import ac.kr.jejunu.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Boobby on 17-5-15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
