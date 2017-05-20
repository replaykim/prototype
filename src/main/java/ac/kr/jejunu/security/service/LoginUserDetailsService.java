package ac.kr.jejunu.security.service;

import ac.kr.jejunu.repository.UserRepository;
import ac.kr.jejunu.common.entity.User;
import ac.kr.jejunu.security.model.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Boobby on 17-5-15.
 */
@Service
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
