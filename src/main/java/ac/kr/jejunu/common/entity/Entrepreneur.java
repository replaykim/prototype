package ac.kr.jejunu.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by blue on 2017-05-16.
 */
@Entity
@Data
@Table(name = "entrepreneur_info")
public class Entrepreneur {
    @Id
    @Column(name = "user_no",insertable = false, updatable = false)
    private Long user_no;

    @OneToOne
    @PrimaryKeyJoinColumn(name="user_no", referencedColumnName="user_no")
    private User user;

    @Column(name = "company_name", length = 50, nullable = false)
    private String company_name;
}
