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
    @Column(name = "category_no")
    private Long no;

    @Column(name = "category_name", nullable = false)
    private String name;
}
