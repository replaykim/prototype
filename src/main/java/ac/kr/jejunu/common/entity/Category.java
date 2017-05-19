package ac.kr.jejunu.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by replay on 2017. 5. 14..
 */

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_no; //식별자
    @Column(name = "category_name",length = 255,nullable = true)
    private String category_name; //카테고리 이름
}
