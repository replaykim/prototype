package ac.kr.jejunu.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Boobby on 17-5-19.
 */
@Entity
@Data
@Table(name = "student_info")
public class Student {
    @Id
    @Column(name = "user_no",insertable = false, updatable = false)
    private Long user_no;

    @OneToOne
    @PrimaryKeyJoinColumn(name="user_no", referencedColumnName="user_no")
    private User user;

    @Column(name = "student_email", length = 100, nullable = false)
    String student_email; //인증 이메일

    @Column(name = "student_email_verification", length = 1, nullable = true)
    String student_email_verification; //인증여부

}
