package ac.kr.jejunu.service;

import ac.kr.jejunu.common.entity.User;
import ac.kr.jejunu.repository.UserRepository;
import ac.kr.jejunu.common.domain.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Boobby on 17-5-15.
 */
@Service
@Transactional
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(userEmail);

        if (user == null) {
            throw new UsernameNotFoundException("User name not found. Login failed.");
        }

        return new LoginUserDetails(user);
    }
}
