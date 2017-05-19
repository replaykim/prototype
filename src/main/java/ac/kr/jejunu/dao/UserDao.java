package ac.kr.jejunu.dao;

import ac.kr.jejunu.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Boobby on 17-5-15.
 */
public interface UserDao extends JpaRepository<User, Long> {
    public User findUserByEmail(String email);
}
