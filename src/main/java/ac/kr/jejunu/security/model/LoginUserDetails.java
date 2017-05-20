package ac.kr.jejunu.security.model;

import ac.kr.jejunu.common.entity.UserType;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Boobby on 17-5-15.
 */
public class LoginUserDetails extends User {
    private static final long serialVersionUID = 1L;

    @Getter
    private long no;

    public LoginUserDetails(ac.kr.jejunu.common.entity.User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUsertype().name()));
        no = user.getUser_no();
    }
}