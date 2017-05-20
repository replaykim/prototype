package ac.kr.jejunu.service;

import ac.kr.jejunu.repository.UserRepository;
import ac.kr.jejunu.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Boobby on 17-5-15.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(String email) {
        return userRepository.findUserByEmail(email);
    }
}
