package ac.kr.jejunu.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by replay on 2017. 5. 14..
 */
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_no")
    private Long no;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UserType userType;

    @Column(name = "password", length = 100, nullable = false)
    private String password;
}
