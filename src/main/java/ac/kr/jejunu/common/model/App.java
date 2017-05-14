package ac.kr.jejunu.common.model;

import lombok.Data;
import lombok.Getter;

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

    String name; // 앱의 이름

    @ManyToOne
    @JoinColumn(name = "uploader_no", referencedColumnName = "user_no")
    private User user;
    private String description; // 앱 설명
    private String version; // 앱 버전
    private Integer volume; // 앱 용량

    @ManyToOne
    @JoinColumn(name = "category_no", referencedColumnName = "category_no")
    private Category category;

    private String storage; // 앱 저장소 URL

    private Integer view_count; // 조회수
    private Integer download_count; // 다운로드 횟수
    private Integer stared; // 별점수

    private Integer fund_goal; // 펀딩 목표 금액
    private Integer fund_amount;// 펀딩된 금액

    private Date register_date;// 신규 업로드 일자
    private Date update_date;// 최근 업데이트 일자
}
