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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer category_no; //식별자
    private String category_name; //카테고리 이름
}
