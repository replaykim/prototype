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
    @GeneratedValue
    private Long category_no;

    @Column(name = "category_name")
    private String category_name;
}
