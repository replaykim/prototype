package ac.kr.jejunu.common.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by replay on 2017. 5. 14..
 */

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_no;// 식별자

    @ManyToOne
    @JoinColumn(name = "app_no", referencedColumnName = "app_no", nullable = false)
    private App app; // 앱에 대한 외래키 참조 설정


    @ManyToOne
    @JoinColumn(name = "writer_no", referencedColumnName = "user_no")
    private User user; // 댓글 작성자에 대한 참조

    private String title;// 제목
    private String content; // 내용
    private Integer star;// 별점 평균
}
