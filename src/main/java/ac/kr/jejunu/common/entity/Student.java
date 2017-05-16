package ac.kr.jejunu.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by replay on 2017. 5. 15..
 */
@Entity
@Data
@Table(name = "student_info")
public class Student implements Serializable {
    @Id
    @Column(name = "user_no",insertable = false, updatable = false)
    private Long user_no;

    @PrimaryKeyJoinColumn(name = "user_no", referencedColumnName = "user_no")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @Column(name = "student_email", length = 100, nullable = false)
    String student_email; //인증 이메일


    @Column(name = "student_email_verification", length = 1, nullable = true)
    String student_email_verification; //인증여부

}
