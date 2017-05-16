package ac.kr.jejunu.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by replay on 2017. 5. 14..
 */

@Entity
@Data
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long app_no; // 식별자

    @Column(name = "name", length = 30, nullable = false)
    private String name; // 앱의 이름

    @ManyToOne
    @JoinColumn(name = "uploader_no", referencedColumnName = "user_no")
    private Student student;

    @Column(name = "description", length = 1000)
    private String description; // 앱 설명
    @Column(name = "version", length = 20, nullable = false)
    private String version; // 앱 버전
    @Column(name = "volume", length = 11, nullable = false)
    private Integer volume; // 앱 용량

    @ManyToOne
    @JoinColumn(name = "category_no", referencedColumnName = "category_no")
    private Category category;

    @Column(name = "storage", length = 256, nullable = false)
    private String storage; // 앱 저장소 URL

    @Column(name = "view_count", length = 11, nullable = true)
    private Integer view_count; // 조회수
    @Column(name = "download_count", length = 11, nullable = true)
    private Integer download_count; // 다운로드 횟수
    @Column(name = "stared", length = 11, nullable = true)
    private Integer stared; // 별점수

    @Column(name = "fund_goal", length = 11, nullable = false)
    private Integer fund_goal; // 펀딩 목표 금액
    @Column(name = "fund_amount", length = 11, nullable = true)
    private Integer fund_amount;// 펀딩된 금액

    @Column(name = "register_date", nullable = true)
    private Date register_date;// 신규 업로드 일자
    @Column(name = "update_date", nullable = true)
    private Date update_date;// 최근 업데이트 일자
}
