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
    @Column(name = "email", length = 50, nullable = true)
    private String email; // 이메일

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_no; // 회원 번호
    @Column(name = "name", length = 50, nullable = true)
    private String name; // 이름

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = true)
    private usertype usertype; // 회원 유형
    @Column(name = "password", length = 100, nullable = true)
    private String password; //비밀번호

    enum usertype {
        nomal, student,entrepreneur
    }
}
