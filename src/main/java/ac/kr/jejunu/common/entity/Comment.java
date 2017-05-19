package ac.kr.jejunu.common.entity;

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

    @Column(name = "title",length = 100,nullable = false)
    private String title;// 제목
    @Column(name = "content",length = 500,nullable = false)
    private String content; // 내용
    @Column(name = "recommend_count",length = 11,nullable = false)
    private Integer recommend_count;// 추천수
}
