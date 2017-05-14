package ac.kr.jejunu.common.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by replay on 2017. 5. 14..
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int user_no; // 회원 번호
    String email; // 이메일
    String name; // 이름
    String type; // 회원 유형
}
