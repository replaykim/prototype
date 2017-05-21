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
    @GeneratedValue
    @Column(name = "comment_no")
    private Long no;

    @ManyToOne
    @JoinColumn(name = "app_no", nullable = false)
    private App app;

    @ManyToOne
    @JoinColumn(name = "writer_no", referencedColumnName = "user_no")
    private User user;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "content", length = 500, nullable = false)
    private String content;

    @Column(name = "recommend_count", nullable = false)
    private Integer recommendedCount;
}
