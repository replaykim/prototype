package ac.kr.jejunu.service;

import ac.kr.jejunu.common.entity.User;
import ac.kr.jejunu.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * Created by Boobby on 17-5-15.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    public User getUser(String email) {
        return userDao.findUserByEmail(email);
    }

    public boolean register(User user) {
        if(userDao.findUserByEmail(user.getEmail()) != null) {
            logger.info("이메일 중복");
            return false;
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        logger.info("save");
        userDao.save(user);

        return true;
    }
}
