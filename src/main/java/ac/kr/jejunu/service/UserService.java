package ac.kr.jejunu.service;

import ac.kr.jejunu.dao.UserDao;
import ac.kr.jejunu.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Boobby on 17-5-15.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(String email) {
        return userDao.findUserByEmail(email);
    }
}
