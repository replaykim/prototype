package ac.kr.jejunu.common.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student_info")
public class StudentInfo {
    @Id
    @Column(name = "user_no",insertable = false, updatable = false)
    private Long user_no;

    @OneToOne
    @PrimaryKeyJoinColumn(name="user_no")
    private User user;

    @Column(name = "student_email", length = 100, nullable = false)
    String email;

    @Column(name = "student_email_verification", length = 1)
    String student_email_verification;
}
